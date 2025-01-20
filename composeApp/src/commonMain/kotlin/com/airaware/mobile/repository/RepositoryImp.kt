package com.airaware.mobile.repository

import com.airaware.mobile.Repository
import com.airaware.mobile.networking.AqiHttpClient
import com.airaware.mobile.networking.AqiWrapperDto
import util.NetworkError
import util.Result

  class RepositoryImp{
     suspend fun getAqi(httpClient: AqiHttpClient): Result<AqiWrapperDto, NetworkError> {
        TODO("Not yet implemented")
    }
}