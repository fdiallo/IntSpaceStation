package com.fallaye.intspacestation.data.network.responses

import com.fallaye.intspacestation.data.db.entities.ISSPosition

data class ISSPositionResponse(
    var iss_position: ISSPosition,
    var message: String,
    var timestamp: Int
)