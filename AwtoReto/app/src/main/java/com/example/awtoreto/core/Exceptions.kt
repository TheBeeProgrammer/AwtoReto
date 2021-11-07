package com.example.awtoreto.core

import java.io.IOException

class NetworkUnavailableException(message: String = "No network available :(") : IOException(message)

class DataNotFound(message: String): Exception(message)