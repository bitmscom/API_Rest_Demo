//
// Created by parallels on 9/13/18.
//

#include <assert.h>
#include "common_tool.h"

unsigned char  common_tool::ToHex(unsigned char x)
{
    return  x > 9 ? x + 55 : x + 48;
}

unsigned char  common_tool::FromHex(unsigned char x)
{
    unsigned char y;
    if (x >= 'A' && x <= 'Z') y = x - 'A' + 10;
    else if (x >= 'a' && x <= 'z') y = x - 'a' + 10;
    else if (x >= '0' && x <= '9') y = x - '0';
    else assert(0);
    return y;
}

std::string common_tool::url_encode(const std::string& str)
{
    std::string strTemp = "";
    size_t length = str.length();
    for (size_t i = 0; i < length; i++)
    {
        if (isalnum((unsigned char)str[i]) ||
            (str[i] == '-') ||
            (str[i] == '_') ||
            (str[i] == '.') ||
            (str[i] == '~'))
            strTemp += str[i];
        else if (str[i] == ' ')
            strTemp += "+";
        else
        {
            strTemp += '%';
            strTemp += ToHex((unsigned char)str[i] >> 4);
            strTemp += ToHex((unsigned char)str[i] % 16);
        }
    }
    return strTemp;
}

std::string common_tool::url_decode(const std::string &str) {
    std::string strTemp = "";
    size_t length = str.length();
    for (size_t i = 0; i < length; i++)
    {
        if (isalnum((unsigned char)str[i]) ||
            (str[i] == '-') ||
            (str[i] == '_') ||
            (str[i] == '.') ||
            (str[i] == '~'))
            strTemp += str[i];
        else if (str[i] == ' ')
            strTemp += "+";
        else
        {
            strTemp += '%';
            strTemp += ToHex((unsigned char)str[i] >> 4);
            strTemp += ToHex((unsigned char)str[i] % 16);
        }
    }
    return strTemp;
}
std::string common_tool::sign(const char *private_key,const std::string &content) {
    BIO *bufio = NULL;
    RSA *rsa = NULL;
    EVP_PKEY *evpKey = NULL;
    bool verify = false;
    EVP_MD_CTX ctx ;
    int result = 0;
    unsigned int size = 0;
    char *sign = NULL;
    std::string signStr = "";

    /*
    bufio = BIO_new_mem_buf((void*)private_key, -1);
    if (bufio == NULL) {
    	ERR("BIO_new_mem_buf failed");
    	goto safe_exit;
    }*/

    bufio = BIO_new(BIO_s_file());
    BIO_read_filename(bufio, "rsa_private_key.pem");

    rsa = PEM_read_bio_RSAPrivateKey(bufio, NULL, NULL, NULL);
    if (rsa == NULL) {
        ERR("PEM_read_bio_RSAPrivateKey failed");
        goto safe_exit;
    }

    evpKey = EVP_PKEY_new();
    if (evpKey == NULL) {
        ERR("EVP_PKEY_new failed");
        goto safe_exit;
    }

    if ((result = EVP_PKEY_set1_RSA(evpKey, rsa)) != 1) {
        ERR("EVP_PKEY_set1_RSA failed");
        goto safe_exit;
    }

    EVP_MD_CTX_init(&ctx);

    if (result == 1 && (result = EVP_SignInit_ex(&ctx, EVP_sha256(), NULL)) != 1) {
        ERR("EVP_SignInit_ex failed");
    }

    if (result == 1 && (result = EVP_SignUpdate(&ctx, content.c_str(), content.size())) != 1) {
        ERR("EVP_SignUpdate failed");
    }

    size = EVP_PKEY_size(evpKey);
    sign = (char*)malloc(size+1);
    memset(sign, 0, size+1);

    if (result == 1 && (result = EVP_SignFinal(&ctx, (unsigned char*)sign, &size, evpKey)) != 1) {
        ERR("EVP_SignFinal failed");
    }

    if (result == 1) {
        verify = true;
    } else {
        ERR("verify failed");
    }

    signStr = base64_encode((const unsigned char*)sign, size);
    EVP_MD_CTX_cleanup(&ctx);
    //EVP_MD_CTX_destroy(ctx);
    free(sign);

    safe_exit:
    if (rsa != NULL) {
        RSA_free(rsa);
        rsa = NULL;
    }

    if (evpKey != NULL) {
        EVP_PKEY_free(evpKey);
        evpKey = NULL;
    }

    if (bufio != NULL) {
        BIO_free_all(bufio);
        bufio = NULL;
    }

    return signStr;
    //return sign;
}

 void common_tool::ERR(const char* string) {
    std::cout<<"error  "<<string<<std::endl;
}

bool common_tool::verify_rsa(/*const char *public_key*/RSA *rsa , const std::string &content, const std::string &sign) {
    BIO *bufio = NULL;
    EVP_PKEY *evpKey = NULL;
    bool verify = false;
     EVP_MD_CTX ctx;
    int result = 0;
    std::string decodedSign = base64_decode(sign);
    char *chDecodedSign = const_cast<char*>(decodedSign.c_str());

    if (rsa == NULL) {
        printf("PEM_read_bio_RSA_PUBKEY failed");
        goto safe_exit;
    }

    evpKey = EVP_PKEY_new();
    if (evpKey == NULL) {
        printf("EVP_PKEY_new failed");
        goto safe_exit;
    }

    if ((result = EVP_PKEY_set1_RSA(evpKey, rsa)) != 1) {
        printf("EVP_PKEY_set1_RSA failed");
        goto safe_exit;
    }

    EVP_MD_CTX_init(&ctx);

    if (result == 1 && (result = EVP_VerifyInit_ex(&ctx,
                                                   EVP_sha256(), NULL)) != 1) {
        printf("EVP_VerifyInit_ex failed");
    }

    if (result == 1 && (result = EVP_VerifyUpdate(&ctx,
                                                  content.c_str(), content.size())) != 1) {
        printf("EVP_VerifyUpdate failed");
    }

    if (result == 1 && (result = EVP_VerifyFinal(&ctx, (unsigned char*)chDecodedSign, decodedSign.size(), evpKey)) != 1) {
        printf("EVP_VerifyFinal failed");
    }
    if (result == 1) {
        verify = true;
    } else {
        printf("verify failed");
    }

    EVP_MD_CTX_cleanup(&ctx);
    safe_exit:
    if (rsa != NULL) {
        RSA_free(rsa);
        rsa = NULL;
    }

    if (evpKey != NULL) {
        EVP_PKEY_free(evpKey);
        evpKey = NULL;
    }

    if (bufio != NULL) {
        BIO_free_all(bufio);
        bufio = NULL;
    }

    return verify;
}
