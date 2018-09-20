//
// Created by parallels on 9/11/18.
//

#ifndef UNTITLED1_AES_BASE64_H
#define UNTITLED1_AES_BASE64_H


#include <iostream>
#include "AES.h"
#include "Base64.h"
using namespace std;

const char g_key[17] = "123456789";
const char g_iv[17] = "0102030405060708";
string EncryptionAES(const string& strSrc);
string DecryptionAES(const string& strSrc);

string EncryptionAES(const string& strSrc,const char* encrypt_key);
string DecryptionAES(const string &strSrc,const char* encrypt_key);

#endif //UNTITLED1_AES_BASE64_H
