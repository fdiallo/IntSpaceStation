package com.fallaye.intspacestation.data.network.responses

import com.fallaye.intspacestation.data.db.entities.Response

data class ISSPositionResponse(
    var message: String,
    var response: List<Response>
)