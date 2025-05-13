package src.net.proteanit.sql;


import jdk.javadoc.internal.doclets.toolkit.Content;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class XmlUtils {
	private static String ROOT_NODE_NAME = "dataset";
	private static String ROW_NODE_NAME = "row";
		

	public static String resultSetToXml(ResultSet rs) {
		String result = null;
		try {
			Document root = new Document(new Element() {
				@Override
				public javax.swing.text.Document getDocument() {
					return null;
				}

				@Override
				public Element getParentElement() {
					return null;
				}

				@Override
				public String getName() {
					return "";
				}

				@Override
				public AttributeSet getAttributes() {
					return null;
				}

				@Override
				public int getStartOffset() {
					return 0;
				}

				@Override
				public int getEndOffset() {
					return 0;
				}

				@Override
				public int getElementIndex(int offset) {
					return 0;
				}

				@Override
				public int getElementCount() {
					return 0;
				}

				@Override
				public Element getElement(int index) {
					return null;
				}

				@Override
				public boolean isLeaf() {
					return false;
				}
			});
			ResultSetMetaData metaData = rs.getMetaData();
			// Get all rows.
			while (rs.next()) {
				Element row = new Element() {
					@Override
					public javax.swing.text.Document getDocument() {
						return null;
					}

					@Override
					public Element getParentElement() {
						return null;
					}

					@Override
					public String getName() {
						return "";
					}

					@Override
					public AttributeSet getAttributes() {
						return null;
					}

					@Override
					public int getStartOffset() {
						return 0;
					}

					@Override
					public int getEndOffset() {
						return 0;
					}

					@Override
					public int getElementIndex(int offset) {
						return 0;
					}

					@Override
					public int getElementCount() {
						return 0;
					}

					@Override
					public Element getElement(int index) {
						return null;
					}

					@Override
					public boolean isLeaf() {
						return false;
					}
				};
				// Add to root
				root.getRootElement().addContent((Content) row);
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					// Use the column label as the node name
					Element val = new Element(metaData.getColumnLabel(i)) {
						@Override
						public javax.swing.text.Document getDocument() {
							return null;
						}

						@Override
						public Element getParentElement() {
							return null;
						}

						@Override
						public String getName() {
							return "";
						}

						@Override
						public AttributeSet getAttributes() {
							return null;
						}

						@Override
						public int getStartOffset() {
							return 0;
						}

						@Override
						public int getEndOffset() {
							return 0;
						}

						@Override
						public int getElementIndex(int offset) {
							return 0;
						}

						@Override
						public int getElementCount() {
							return 0;
						}

						@Override
						public Element getElement(int index) {
							return null;
						}

						@Override
						public boolean isLeaf() {
							return false;
						}
					};
					// Use the String value of the data as the value node's child
					Object o = rs.getObject(i);
					val.setText(o == null? "null" : o.toString());
					row.addContent(val);
				}
			}
			XMLOutputter out = new XMLOutputter();
			out.setFormat(Format.getPrettyFormat());
			result = out.outputString(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param args
	 */
	
	// Only for demo/testing
	public static void main(String[] args) throws Exception {
		ResultSet d = new net.proteanit.sql.DummyNRowCol(4, 10);
		System.out.println(XmlUtils.resultSetToHtml(d));

	}

	public static String resultSetToHtml(ResultSet rs) {
		String result = null;
		try {
			Document root = new Document(new Element("table"));
			ResultSetMetaData metaData = rs.getMetaData();
			// Get all rows.
			while (rs.next()) {
				Element row = new Element("tr");
				// Add to root
				root.getRootElement().addContent(row);
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					Element val = new Element("td");
					// Use the String value of the data as the value node's child
					val.setText(rs.getObject(i).toString());
					row.addContent(val);
				}
			}
			XMLOutputter out = new XMLOutputter();
			out.setFormat(Format.getPrettyFormat());
			result = out.outputString(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
