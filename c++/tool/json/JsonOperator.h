//
// Created by parallels on 9/11/18.
//

#ifndef UNTITLED1_JSONOPERATOR_H
#define UNTITLED1_JSONOPERATOR_H

#include "lib_json/json/json.h"
#include <iostream>
#include <string>
#include <vector>
#include <sys/time.h>

#include "../cryptor/AES-base64.h"
#include "../cryptor/common_tool.h"
using namespace std;

class JsonOperator {
private:
    string api_key="UBASSo5zHnXdaDBKXQRhHL1msJAVktk86FoUf51tixESonGf2YlmKrw6CQsRBwH9";
public:
    JsonOperator(){}
    JsonOperator(string api_key){
        this->api_key=api_key;
    }
public:
    common_tool ct;
    /**
     * @brief build up the requestJson with content
     * @param content input parameter
     * @return requestJson
     * including charset,encrypt_key,api_key,format,version,sign_type,timestamp,content
     * encrypt_key:the key used in AES crypto,use the timestamp
     * api_key:change to your own api key
     */
    std::string DataToJson(const std::string content,const std::string encrypt_key);

    /**
     * @brief build up the requestJson without content
     * @param content input parameter
     * @return requestJson
     * including charset,encrypt_key,api_key,format,version,sign_type,timestamp
     */
    std::string DataToJson(const std::string encrypt_key);

    /**
     * @brief  decrypt data by AES
     * @param content input parameter,resJson needs to be decrypted
     * @return decrypted resJson
     */
    std::string DataDES(const std::string content);
    /**
     *  @brief  decrypt data by AES
     * @param content input parameter,resJson needs to be decrypted
     * @param encrypt_key uesd in AES encrypt
     * @return decrypted json
     */
    std::string DataDES(const std::string content,const char* encrypt_key);

    /**
     * @brief DataToformat2 with "/n"
     * @param requestJson
     * @return
     */
    std::string DataTofomat1(const std::string requestJson);

    /**
     * @brief use the '=' stitching between the key-value pairs, and the multiple-key pairs using the '&' stitching
     * @param requestJson input parameter
     * @return
     */
    std::string DataTofomat2(const std::string requestJson);

    /**
     * @brief split function (one seperator)
     * @param seperator
     * @return vector
     */
    vector<string> SplitString(const string& requestJson, const string& c);

    /**
     * @brief Get request URL, Need to URL encode all request parameter values.
     * @param content
     * @param sign sha256withrsa signature about the content
     * @return URL parameters part
     */
    string DataToURL(const string content,const char* sign);

    /**
     * @brief Get request URL with content , Need to URL encode all request parameter values.
     * @param content
     * @param sign sha256withrsa signature about the content
     * @return URL parameter part
     */
    string DataToURL_content(const string content,const char* sign);

//------------------------------
    /**
     * @brief transfer key-value to json
     * @param mapcontent
     * @return
     */
    string general_content(const map<string,string> mapcontent);

    /**
     * @brief transfer key-value(vector) to json
     * @param mapcontent
     * @return
     */
    string general_content1( const map<string,vector<string>> mapcontent);
};


#endif //UNTITLED1_JSONOPERATOR_H
