import services.graphicService.*
import services.graphicService.components.mainBar.MainBar
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class Window: JFrame() {
    private val screenWidth = 800
    private val screenHeight = 500

    private val mainBar = MainBar(screenWidth, this)
    private val title = JLabel()
    private val text = JTextArea()
    private val button = JButton()

    init {
        mainBar.setLogo(ImageIcon("resources/logo.png"))
        add(mainBar)

        title.setProperties(50, 50, 220, 64, "Regla del producto", darkWhite, fontTitle2)
        add(title)

        text.setProperties(
            50, 150, 700, 100, "Si un procedimiento se puede descomponer en las etapas primera y segunda, y existen m resultados" +
                    " posibles de la primera etapa y si, para cada uno de estos resultados, existen n resultados posibles para la segunda etapa, entonces" +
                    " el procedimiento total se puede realizar, en el orden dado de mn formas", darkWhite, fontText, false
        )
        add(text)

        button.setProperties(350, 400, 100, 35, "Calcular")
        button.addActionListener(Calcular)
        add(button)

        setProperties(screenWidth, screenHeight)
    }
}

object Calcular: ActionListener {
    override fun actionPerformed(e: ActionEvent?) {
        try {
            val tareas = JOptionPane.showInputDialog(null, "Ingrese cantidad de etapas", "Pregunta",
                JOptionPane.QUESTION_MESSAGE).toInt()

            var formas = 1
            for(i in 0 until tareas) {
                formas *= (JOptionPane.showInputDialog(null, "Ingrese la cantidad de resultados posibles de la etapa" +
                        " ${i+1}", "Pregunta", JOptionPane.QUESTION_MESSAGE).toInt())
            }
            JOptionPane.showMessageDialog(null, "Todas sus tareas se pueden realizar de $formas formas diferentes")
        }catch (nulls: NullPointerException) {
        }catch (format: NumberFormatException) {
            JOptionPane.showMessageDialog(null, "El valor ingresado no es un número", "Error", JOptionPane.ERROR_MESSAGE)
        }
    }
}