package study.gui

import scala.swing._
import scala.collection.mutable.ListBuffer
import java.awt._
import scala.swing.event.ButtonClicked
import scala.swing.Button
import scala.swing.Component
import scala.swing.Font
import scala.swing.ScrollPane
import java.awt.Color
import java.awt.geom.{RoundRectangle2D, Area}

case class DataItem(id: Long, name: String)

object Gui extends SimpleSwingApplication {

  val items = ListBuffer[DataItem]()
  (1 to 20).foreach(i => items += DataItem(i, "item %s" format i))

  val testModel = new LabsTableModel(Array("Id", "Name")) {
    def getRowCount: Int = items.length

    def getValueAt(rowIndex: Int, columnIndex: Int): AnyRef = {
      val data = items(rowIndex)
      columnIndex match {
        case 0 => data.id.asInstanceOf[AnyRef]
        case 1 => data.name
        case _ => ""
      }
    }
  }

  val testTable = new LabsTable {
    model = testModel
    peer.setVisibleRowCount(10)
  }
  val tableScroll = new ScrollPane(testTable)
  val testButton = new Button("Test")

  val frame = new MainFrame {
    title = "Study"
    val panel = new BorderPanel {

      border = Swing.EmptyBorder(20)
      add(tableScroll, BorderPanel.Position.Center)
      add(testButton, BorderPanel.Position.South)
    }
    contents = panel
    size = new Dimension(600, 400)
  }

  val glass = new Component {

    val bigFont = new Font("Sans Serif", Font.BOLD, 98)
    peer.setFont(bigFont)
    override def paint(g: _root_.scala.swing.Graphics2D) {
      super.paint(g)

      g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .2f))

      g.setColor(Color.orange)
      g.fillOval(50, 50, 150, 150)
      g.setColor(Color.red)

      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

      val fm = g.getFontMetrics
      val msg = "Demo"
      val msgWidth = fm.stringWidth(msg)
      val msgAscent = fm.getAscent
      val msgX = peer.getWidth / 2 - msgWidth / 2
      val msgY = peer.getHeight / 2 + msgAscent / 2
      g.drawString(msg, msgX, msgY)

      val roundX = msgX - 20
      val roundY = msgY - msgAscent
      val roundW = msgWidth + 40
      val roundH = fm.getHeight
      val area = new Area(new RoundRectangle2D.Float(roundX, roundY, roundW, roundH, 20, 20))
      g.setStroke(new BasicStroke(10))
      g.draw(area)
    }
  }
  frame.peer.setGlassPane(glass.peer)
  frame.peer.getGlassPane.setVisible(true)

  centerWindowToScreen(frame)

  def centerWindowToScreen(window: RichWindow) = {
    val x = getX(window.size.width)
    val y = getY(window.size.height)
    window.location = point(x, y)
  }

  private def screenSize = Toolkit.getDefaultToolkit().getScreenSize()
  private def getX(componentWidth: Int) = screenSize.width / 2 - componentWidth / 2
  private def getY(componentHeight: Int) = screenSize.height / 2 - componentHeight / 2
  private def point(x: Int, y: Int) = new java.awt.Point(x, y)

  def top = frame

  listenTo(testButton)
  reactions += {
    case ButtonClicked(`testButton`) => println("aloha")
  }
}