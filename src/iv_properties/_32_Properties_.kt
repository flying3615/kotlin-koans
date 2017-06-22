package iv_properties

import util.TODO
import util.doc32

class PropertyExample {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(v){
            field = v // Kotlin provides an automatic backing field which can be accessed using the field identifier
            counter++
        }
}

fun todoTask32(): Nothing = TODO(
    """
        Task 32.
        Add a custom setter to PropertyExample.propertyWithCounter so that
        the 'counter' property is incremented every time 'propertyWithCounter' is assigned to.
    """,
    documentation = doc32(),
    references = { PropertyExample() }
)
