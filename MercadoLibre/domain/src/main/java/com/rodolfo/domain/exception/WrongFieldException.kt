package com.rodolfo.domain.exception

import java.lang.RuntimeException

class WrongFieldException(override val message: String?) : RuntimeException(message)