//
// Created by parallels on 9/11/18.
//

#include "JsonOperator.h"
#include <string>
#include <iconv.h>
long long getCurrentTime()
{
    struct timeval tv;
    gettimeofday(&tv,NULL);
    return tv.tv_sec * 1000 + tv.tv_usec / 1000;
};
std::string JsonOperator::DataToJson(const std::string content,const std::string encrypt_key) {
    Json::FastWriter writerBuilder;
    Json::StyledWriter styledWriter;
    Json::Value writervalue;

    writervalue["charset"]="UTF-8";
    writervalue["encrypt_key"]=encrypt_key;
    writervalue["api_key"]=api_key;
    writervalue["format"]="json";
    writervalue["version"]="1.0";
    writervalue["sign_type"]="RSA2";
    writervalue["timestamp"]=to_string(getCurrentTime());
    writervalue["content"]=content;

    std::string strEmail =styledWriter.write(writervalue);

    return strEmail;

}
std::string JsonOperator::DataToJson(const std::string encrypt_key) {
    Json::FastWriter writerBuilder;
    Json::StyledWriter styledWriter;
    Json::Value writervalue;

    writervalue["charset"]="UTF-8";
    writervalue["encrypt_key"]=encrypt_key;
    writervalue["api_key"]=api_key;
    writervalue["format"]="json";
    writervalue["version"]="1.0";
    writervalue["sign_type"]="RSA2";
    writervalue["timestamp"]=to_string(getCurrentTime());

    std::string strEmail =styledWriter.write(writervalue);

    return strEmail;

}

vector<string> JsonOperator::SplitString(const string& s, const string& c)
{
    string::size_type pos1, pos2;
    vector<string> v;
    pos2 = s.find(c);
    pos1 = 0;
    while(string::npos != pos2)
    {
        v.push_back(s.substr(pos1, pos2-pos1));

        pos1 = pos2 + c.size();
        pos2 = s.find(c, pos1);
    }
    if(pos1 != s.length())
        v.push_back(s.substr(pos1));
    return v;
}
std::string JsonOperator::DataTofomat1(const std::string requestJson)
{
    vector<string> vector1=SplitString(requestJson,",");
    string signcontent;
    for(int i=0;i<vector1.size();i++){
        if(i==0) signcontent+="";
        else signcontent+="&";
        vector<string> vector2=SplitString(vector1[i],":");
        signcontent+=SplitString(vector2[0],"\"")[1]+"="+SplitString(vector2[1],"\"")[1]+"\n";
    }

    return signcontent;
}
std::string JsonOperator::DataTofomat2(const std::string requestJson)
{
    vector<string> vector1=SplitString(requestJson,",");
    string signcontent;
    for(int i=0;i<vector1.size();i++){
        if(i==0) signcontent+="";
        else signcontent+="&";
        vector<string> vector2=SplitString(vector1[i],":");
        signcontent+=SplitString(vector2[0],"\"")[1]+"="+SplitString(vector2[1],"\"")[1];
    }

    return signcontent;
}
string JsonOperator::DataToURL(const string content,const char* sign){
    Json::Reader reader;
    Json::Value root;
    if(reader.parse(content,root)){
        root["sign"]=sign;
        root["sign"].asString();
        if(root["content"].isString()){
            string content_url=root["content"].asString();
            root.removeMember("content");
            root["content"]=ct.url_encode(content_url);
        }
        else{root.removeMember("content");}
        Json::StyledWriter styledWriter;
        std::string strsigned =styledWriter.write(root);
        return DataTofomat2(strsigned);
    }
}

string JsonOperator::DataToURL_content(const string content,const char* sign){
    Json::Reader reader;
    Json::Value root;
    if(reader.parse(content,root)){
        root["sign"]=sign;
        root["sign"].asString();
        root.removeMember("content");
        Json::StyledWriter styledWriter;
        std::string strsigned =styledWriter.write(root);
        return DataTofomat2(strsigned);
    }
}
std::string JsonOperator::DataDES(const std::string content){
    Json::Reader reader;
    Json::Value root;
    if(reader.parse(content,root)){
        if(root["data"].isString()) {
            string data = root["data"].asString();
            root.removeMember("data");
            Json::Value temp;
            reader.parse(DecryptionAES(data), temp);
            root["data"] = temp;
        }
      //  cout<<DecryptionAES(data)<<endl;
        Json::FastWriter styledWriter;
        std::string strdec =styledWriter.write(root);
        return strdec;
    }
}
std::string JsonOperator::DataDES(const std::string content,const char* encrypt_key){
    Json::Reader reader;
    Json::Value root;
    if(reader.parse(content,root)){
        if(root["data"].isString()) {
            string data = root["data"].asString();
            root.removeMember("data");
            Json::Value temp;
            reader.parse(DecryptionAES(data,encrypt_key), temp);
            root["data"] = temp;
        }
        //  cout<<DecryptionAES(data)<<endl;
        Json::FastWriter styledWriter;
        std::string strdec =styledWriter.write(root);
        return strdec;
    }
}
//------------------------------------------------------------------------
//params
//-----------------------------------------------------------------------

string JsonOperator::general_content( map<string,string> mapcontent){
    Json::FastWriter writerBuilder;
    Json::Value writervalue;
    map<string, string>::iterator iter;
    iter=mapcontent.begin();
    while(iter != mapcontent.end()) {
        writervalue[iter->first]=iter->second;
        iter++;}
    std::string strEmail =writerBuilder.write(writervalue);

    return strEmail;
}
string JsonOperator::general_content1( map<string,vector<string>> mapcontent){
    Json::FastWriter writerBuilder;
    Json::Value writervalue;
    map<string,vector<string>>::iterator iter;
    iter=mapcontent.begin();
    while(iter != mapcontent.end()) {
        Json::Value value;
        for(int i=0;i<iter->second.size();i++)
        value.append(iter->second[i]);
        writervalue[iter->first]=value;
        iter++;}
    std::string strEmail =writerBuilder.write(writervalue);

    return strEmail;
}