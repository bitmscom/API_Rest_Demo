//
// Created by parallels on 9/10/18.
//

#ifndef UNTITLED1_HTTPCLIENT_H
#define UNTITLED1_HTTPCLIENT_H

#endif //UNTITLED1_HTTPCLIENT_H

#ifndef __HTTP_CURL_H__
#define __HTTP_CURL_H__

#include <string>
#include "../cryptor/AES-base64.h"
#include "../json/JsonOperator.h"
#include "../cryptor/common_tool.h"
#include <sys/time.h>


class CHttpClient
{
public:
    CHttpClient(void);
    ~CHttpClient(void);

public:
    /**
    * @brief HTTP POST request
    * @param strUrl input parameters, the requested Url address, such as: http://www.baidu.com
    * @param strPost input parameters, using the following format para1=val1¶2=val2&...
    * @param strResponse output parameters, returned content
    * @return Returns whether Post is successful
    */
    int Post(const std::string & strUrl, const std::string & strPost, std::string & strResponse);

    /**
    * @brief HTTP GET request
    * @param strUrl input parameters, the requested Url address, such as: http://www.baidu.com
    * @param strResponse output parameters, returned content
    * @return Returns whether Post is successful
    */
    int Get(const std::string & strUrl, std::string & strResponse);

    /**
     * @brief HTTPS POST request, no certificate version
     * @param strUrl input parameter, the requested Url address, such as: https://www.alipay.com
     * @param strPost input parameters, using the following format para1=val1¶2=val2&...
     * @param strResponse output parameters, returned content
     * @param pCaPath Input parameter, the path to the CA certificate. If the input is NULL, the validity of the server-side certificate is not verified.
     * @return Returns whether Post is successful
    */
    int Posts(const std::string & strUrl, const std::string & strPost, std::string & strResponse, const char * pCaPath = NULL);

    /**
     * @brief HTTPS GET request, no certificate version
     * @param strUrl input parameter, the requested Url address, such as: https://www.alipay.com
     * @param strResponse output parameters, returned content
     * @param pCaPath Input parameter, the path to the CA certificate. If the input is NULL, the validity of the server-side certificate is not verified.
     * @return Returns whether Post is successful
    */
    int Gets(const std::string & strUrl, std::string & strResponse, const char * pCaPath = NULL);

    /*-----------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * @brief HTTP POST CRYPTED request
     * @param strUrl input parameters, the requested Url address, such as: http://www.baidu.com
     * @param strPost input parameters,the content requested ,need to be crypted ,such as:{"symbol":"btc2usd"}
     * @param strResponse output parameters, returned content
     * @return decrpted resJson
     */
    int Post_crypt(const std::string & strUrl, const std::string & strPost, std::string & strResponse);


    /**
     * @brief HTTP GET CRYPTED request
     * @param strUrl input parameters, the requested Url address, such as: http://www.baidu.com
     * @param strResponse output parameters, returned content
     * @param strPost default null,the content may requested,such as:{"symbol":"btc2usd"}
     * @return decrpted resJson
     */
    int Get_crypt(const std::string & strUrl, std::string & strResponse,const string &strPost="");

public:
    void SetDebug(bool bDebug);

private:
    bool m_bDebug;
};

#endif
