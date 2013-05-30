package study.gui

import scala.swing.{MainFrame, Frame, SimpleSwingApplication}


object Gui extends SimpleSwingApplication {
  def top: Frame = new MainFrame {
    title = "Study"
  }
}