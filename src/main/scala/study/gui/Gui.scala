package study.gui

import scala.swing._
import scala.collection.mutable.ListBuffer
import java.awt._
import scala.swing.event.ButtonClicked
import scala.swing.Button
import scala.swing.ScrollPane
import java.awt.Color


object Gui extends SimpleSwingApplication {

  val testModel = new LabsTableModel(Array("Id", "Name")) {

    case class DataItem(id: Long, name: String)

    val items = ListBuffer[DataItem]()
    (1 to 20).foreach(i => items += DataItem(i, "item %s" format i))

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

  val mark = new Watermark("Demo", .1f, Color.red)
  frame.peer.setGlassPane(mark.peer)
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