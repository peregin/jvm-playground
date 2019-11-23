package study.gui

import scala.swing.Component
import java.awt._
import javax.swing.Timer
import java.awt.event.{ActionListener, ActionEvent}
import java.awt.geom.{RoundRectangle2D, Area}


class Watermark(msg: String, alpha: Float, paintColor: Color) extends Component with ActionListener {

  val bigFont = new Font("Sans Serif", Font.BOLD, 98)
  peer.setFont(bigFont)

  val timer = new Timer(500, this)

  def actionPerformed(e: ActionEvent): Unit = {
  }

  override def paint(g: _root_.scala.swing.Graphics2D): Unit = {
    super.paint(g)

    g.setColor(paintColor)
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha))
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

    val msgAngle = -45d
    val w = peer.getWidth
    val h = peer.getHeight
    g.rotate(Math.PI / 180 * msgAngle, w/2, h/2)

    val fm = g.getFontMetrics
    val msgWidth = fm.stringWidth(msg)
    val msgAscent = fm.getAscent
    val msgX = w / 2 - msgWidth / 2
    val msgY = h / 2 + msgAscent / 2
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