package services.graphicService

import java.awt.*
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.*
import javax.swing.border.Border
import javax.xml.stream.Location

fun JFrame.setProperties(width: Int = 1280, height: Int = 720, background: Color? = semiDarkGrayBlue, undecorated: Boolean = true,
                         border: Border? = blackBorderTransparent, relativeLocation: Component? = null, visible: Boolean = true,
                         layoutManager: LayoutManager? = null) {
    this.setSize(width, height)
    this.setLocationRelativeTo(relativeLocation)
    this.contentPane.background = background
    this.isUndecorated = undecorated
    this.rootPane.border = border
    this.layout = layoutManager
    this.isVisible = visible
}

fun JPanel.setProperties(x: Int, y: Int, width: Int, height: Int, color: Color?, layoutManager: LayoutManager?, border: Border? = null) {
    this.setBounds(x, y, width, height)
    this.background = color
    this.border = border
    this.layout = layoutManager
}

/**
 * icon label
 */
fun JLabel.setProperties(x: Int, y: Int, icon: Icon, cursor: Cursor? = null) {
    this.setSize(icon.iconWidth, icon.iconHeight)
    this.setLocation(x, y)
    this.icon = icon
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    this.cursor = cursor
}

/**
 * text label
 */
fun JLabel.setProperties(x: Int, y: Int, width: Int, height: Int, str: String?, fontColor: Color?, font: Font?, hAlignment: String? = "LEFT") {
    this.setBounds(x, y, width, height)
    this.foreground = fontColor
    this.font = font
    this.text = str
    this.horizontalAlignment = when(hAlignment) {
        "CENTER" -> SwingConstants.CENTER
        "RIGHT" -> SwingConstants.RIGHT
        else -> SwingConstants.LEFT
    }
}

fun JFrame.setProperties(width: Int, height: Int, layoutManager: LayoutManager?, background: Color? = null, title: String? = null) {
    this.setSize(width, height)
    this.setLocationRelativeTo(null)
    this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    this.title = title
    this.layout = layout
    this.contentPane.background = background
    this.isVisible = true
}

/**
 * Icon button
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun JButton.setProperties(x: Int, y: Int, icon: Icon?, cursor: Cursor? = handCursor) {
    this.setLocation(x, y)
    this.isContentAreaFilled = false
    this.border = null
    this.cursor = cursor
    this.isFocusable = false
    if (icon != null) {
        this.setSize(icon.iconWidth, icon.iconHeight)
        this.icon = icon
    }
}

/**
 * text button
 */
fun JButton.setProperties(x: Int, y: Int, width: Int, height: Int, text: String?, cursor: Cursor? = handCursor, font: Font? = fontButton,
                          background: Color? = darkGray, foreground: Color? = darkWhite, border: Border? = semiDarkGray2Border,
                          alignment: String? = "CENTER", isSolid: Boolean = true) {
    setProperties(x, y, width, height, cursor, background, isSolid)
    this.text = text
    this.font = font
    this.foreground = foreground
    this.border = border
    this.horizontalAlignment = when (alignment) {
        "LEFT" -> SwingConstants.LEFT
        "RIGHT" -> SwingConstants.RIGHT
        else -> SwingConstants.CENTER
    }

    this.addMouseListener(object : MouseListener {
        override fun mouseClicked(e: MouseEvent) {
        }

        override fun mousePressed(e: MouseEvent) {
        }

        override fun mouseReleased(e: MouseEvent) {
        }

        override fun mouseEntered(e: MouseEvent) {
            this@setProperties.background = semiDarkGray
        }

        override fun mouseExited(e: MouseEvent) {
            this@setProperties.background = darkGray
        }
    })
}

/**
 * text button filled with icon
 */
fun JButton.setProperties( x: Int,y: Int, width: Int, height: Int, cursor: Cursor?, background: Color?, isSolid: Boolean, icon: Icon? = null) {
    this.setProperties(x, y, icon, cursor)
    this.setSize(width, height)
    this.background = background
    this.isContentAreaFilled = isSolid
}

fun JTextArea.setProperties(x: Int, y: Int, width: Int, height: Int, text: String? = "", foreground: Color? = black, font: Font?,
                             editable: Boolean, border: Border? = null) {
    this.setBounds(x, y, width, height)
    this.text = text
    this.isEditable = editable
    this.foreground = foreground
    this.font = font
    this.background = transparent
    this.caretColor = foreground
    this.border = border
    this.wrapStyleWord = true
    this.lineWrap = true
}