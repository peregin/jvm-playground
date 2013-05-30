package study.gui

import scala.swing.Table
import org.jdesktop.swingx.JXTable
import org.jdesktop.swingx.decorator.HighlighterFactory
import javax.swing.ListSelectionModel
import java.awt.{Point, Color}
import javax.swing.table.AbstractTableModel

abstract class LabsTableModel(val header: Array[String]) extends AbstractTableModel {

  override def getColumnName(column: Int) = header(column).toString
  override def getColumnCount() = header.size
}

class LabsTable extends Table {

  override lazy val peer: JXTable = new JXTable with SuperMixin

  // disable column reordering
  peer.getTableHeader.setReorderingAllowed(false)
  // highlight odd rows
  peer.addHighlighter(HighlighterFactory.createSimpleStriping(Color.lightGray))
  selectionMode = ListSelectionModel.SINGLE_SELECTION

  def selectionMode: Int = peer.getSelectionMode
  def selectionMode_=(mode: Int) = peer.setSelectionMode(mode)

  def modelColumnRowAtPoint(point: Point): Option[Point] = {
    val viewRow = this.peer.rowAtPoint(point)
    if (viewRow >= 0) {
      val modelRowIndex = peer.convertRowIndexToModel(viewRow)
      val columnIndex = this.peer.columnAtPoint(point)
      val modelColumnIndex = modelToViewColumn(columnIndex)
      Some(new Point(modelColumnIndex, modelRowIndex))
    } else None
  }
}