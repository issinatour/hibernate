package clases;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Utilities {

	
	private void adjustJTableRowSizes(JTable jTable) {
	        for (int row = 0; row < jTable.getRowCount(); row++) {
	            int maxHeight = 0;
	            for (int column = 0; column < jTable.getColumnCount(); column++) {
	                TableCellRenderer cellRenderer = jTable.getCellRenderer(row, column);
	                Object valueAt = jTable.getValueAt(row, column);
	                Component tableCellRendererComponent = cellRenderer.getTableCellRendererComponent(jTable, valueAt, false, false, row, column);
	                int heightPreferable = tableCellRendererComponent.getPreferredSize().height;
	                maxHeight = Math.max(heightPreferable, maxHeight);
	            }
	            jTable.setRowHeight(row, maxHeight);
	        }

	    }
	 
	 private void adjustColumnSizes(JTable table, int column, int margin) {
	        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
	        TableColumn col = colModel.getColumn(column);
	        int width;

	        TableCellRenderer renderer = col.getHeaderRenderer();
	        if (renderer == null) {
	            renderer = table.getTableHeader().getDefaultRenderer();
	        }
	        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
	        width = comp.getPreferredSize().width;

	        for (int r = 0; r < table.getRowCount(); r++) {
	            renderer = table.getCellRenderer(r, column);
	            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, column), false, false, r, column);
	            int currentWidth = comp.getPreferredSize().width;
	            width = Math.max(width, currentWidth);
	        }

	        width += 2 * margin;

	        col.setPreferredWidth(width);
	        col.setWidth(width);
	    }
	 
	 public void ajustartabla(final JTable tabla){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					adjustJTableRowSizes(tabla);
				
					for (int i = 0; i < tabla.getColumnCount(); i++) {
						adjustColumnSizes(tabla, i, 2);
			        }
					
					
				}
			});
			
		}
}
