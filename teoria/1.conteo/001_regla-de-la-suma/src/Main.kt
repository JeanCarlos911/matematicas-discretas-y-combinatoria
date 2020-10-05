import services.graphicService.*
import services.graphicService.components.mainBar.MainBar
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

fun main() {
    val screenWidth = 800
    val screenHeight = 500

    val frame = JFrame()
    val mainBar = MainBar(screenWidth, frame)
    val title = JLabel()
    val text = JTextArea()
    val button = JButton()

    mainBar.setLogo(ImageIcon("resources/logo.png"))
    frame.add(mainBar)

    title.setProperties(50, 50, 200, 64, "Regla de la suma", darkWhite, fontTitle2)
    frame.add(title)

    text.setProperties(50, 150, 700, 100, "Si una primera tarea puede realizarse de m formas, mientras que una segunda tarea " +
            "puede realizarse de n formas, y no es posible realizar ambas tareas de manera simultánea, entonces, para llevar a cabo cualquiera de " +
            "ellas pueden utilizarse cualquiera de m + n formas.", darkWhite, fontText, false)
    frame.add(text)

    button.setProperties(350, 400, 100, 35, "Calcular")
    button.addActionListener(Calcular)
    frame.add(button)

    frame.setProperties(screenWidth, screenHeight)
}

object Calcular: ActionListener {
    override fun actionPerformed(e: ActionEvent?) {
        try {
            val tareas = JOptionPane.showInputDialog(null, "Ingrese cantidad de tareas", "Pregunta",
                JOptionPane.QUESTION_MESSAGE).toInt()

            val formas = mutableListOf<Int>()
            for(i in 0 until tareas) {
                formas.add(JOptionPane.showInputDialog(null, "Ingrese la cantidad de formas en las que se puede realizar la tarea" +
                        " ${i+1}", "Pregunta", JOptionPane.QUESTION_MESSAGE).toInt())
            }
            JOptionPane.showMessageDialog(null, "Todas sus tareas se pueden realizar de ${formas.sum()} formas")
        }catch (nulo: NullPointerException) {
        }catch (format: NumberFormatException) {
            JOptionPane.showMessageDialog(null, "El valor ingresado no es un número", "Error", JOptionPane.ERROR_MESSAGE)
        }
    }

}