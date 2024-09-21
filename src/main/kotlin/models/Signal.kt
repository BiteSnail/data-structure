package org.example.models

import org.example.constants.Code

data class Signal(val customCode: Code,
                  val dataCode: Code
) {

    override fun toString(): String {
        return "${Code.LEAD.code}-${customCode.code}-${dataCode.code}"
    }
}