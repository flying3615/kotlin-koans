package FP_kt

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.ListView
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.stage.Stage

class App:Application(){

//    val ngrams = TreeSet<NGram>()

    override fun start(stage: Stage?) {
        val edit = TextField()
        val completionList = ListView<String>()

        val vbox = VBox(edit,completionList).apply {
            spacing = 15.0
            padding = Insets(15.0)
        }

//        edit.textProperty().addListener{obv->
//            completionList.items.setAll(ngrams.complete(edit.text))
//        }

        stage?.scene = Scene(vbox)
        stage?.show()

    }

}


fun main(args: Array<String>) {
    Application.launch(App::class.java,*args)
}