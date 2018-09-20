//
// Created by parallels on 9/13/18.
//

#ifndef UNTITLED_3_COMMON_TOOL_H
#define UNTITLED_3_COMMON_TOOL_H

#include <iostream>
#include <cstring>

#include "openssl/sha.h"
#include "openssl/rsa.h"
#include "openssl/rand.h"
#include "openssl/objects.h"
#include "openssl/pem.h"


#include "Base64.h"

class common_tool {
public:
    static unsigned char ToHex(unsigned char x);
    static unsigned char FromHex(unsigned char x);

    /**
     * @brief url encode
     * @param str
     * @return
     */
    static std::string url_encode(const std::string& str);
    /**
     * @brief url decode
     * @param str
     * @return
     */
    static std::string url_decode(const std::string& str);
    /**
     * @brief verify your signature with public_key
     * @param rsa the public_key
     * @param content
     * @param sign the signature
     * @return
     */
    static bool verify_rsa(RSA *rsa ,const std::string &content, const std::string &sign);
    /**
     * @brief sign content with private_key from rsa_private_key.pem
     * @param private_key not use here,but you can try this
     * @param content the content needs to be signed
     * @return the signed string
     * sha256withrsa base64
     */
    static std::string sign(const char *private_key,const std::string &content);
    /**
     * @brief ERROR inform
     * @param string
     */
    static void ERR(const char* string);
};


#endif //UNTITLED_3_COMMON_TOOL_H
