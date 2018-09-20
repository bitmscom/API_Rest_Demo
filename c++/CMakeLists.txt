cmake_minimum_required(VERSION 3.10)
project(bitms-cpp-api)

set(CMAKE_CXX_STANDARD 11)

set(INC_DIR_CURL tool/curl/include)
set(LINK_DIR_CURL tool/curl/lib)
include_directories(${INC_DIR_CURL})
link_directories(${LINK_DIR_CURL})
link_libraries(curl)

set(INC_DIR_OPENSSL tool/openssl/include)
set(LINK_DIR_OPENSSL tool/openssl/lib/lib)
include_directories(${INC_DIR_OPENSSL})
link_directories(${LINK_DIR_OPENSSL})
link_libraries(ssl crypto)

add_subdirectory(tool/googletest)
include_directories(tool/googletest/include)
link_directories(tool/googletest)
set(LIBRARIES
        gtest
        pthread)


add_executable(bitms-cpp-api
        main.cpp
        tool/curl/httpclient.h
        tool/curl/httpclient.cpp
        tool/cryptor/AES.h
        tool/cryptor/AES.cpp
        tool/cryptor/Base64.h
        tool/cryptor/Base64.cpp
        tool/cryptor/AES-base64.h
        tool/cryptor/AES-base64.cpp
        tool/cryptor/common_tool.cpp
        tool/cryptor/common_tool.h
        tool/json/JsonOperator.cpp
        tool/json/JsonOperator.h
        tool/json/lib_json/json/allocator.h
        tool/json/lib_json/json/assertions.h
        tool/json/lib_json/json/autolink.h
        tool/json/lib_json/json/config.h
        tool/json/lib_json/json/features.h
        tool/json/lib_json/json/forwards.h
        tool/json/lib_json/json/json.h
        tool/json/lib_json/json/reader.h
        tool/json/lib_json/json/version.h
        tool/json/lib_json/json/writer.h
        tool/json/lib_json/json/value.h
        tool/json/lib_json/json_tool.h
        tool/json/lib_json/json_reader.cpp
        tool/json/lib_json/json_value.cpp
        tool/json/lib_json/json_writer.cpp
        test/TestQuotation.cpp
        test/TestQuotation.h
        test/TestTrade.cpp
        test/TestTrade.h
        test/test.cpp)
target_link_libraries(bitms-cpp-api curl)
target_link_libraries(bitms-cpp-api ssl)
target_link_libraries(bitms-cpp-api ${LIBRARIES})