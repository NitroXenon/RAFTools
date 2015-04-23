package net.vs49688.rafview.gui;

import net.vs49688.rafview.cli.Model;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.tree.*;
import net.vs49688.rafview.vfs.*;

public class View extends JFrame {

	private final Model m_Model;
	private final ActionListener m_MenuListener;
	private final VFSViewTree.OpHandler m_TreeOpHandler;
	private final Console m_Console;
	
	private String m_LastOpenDirectory;
	
	public View(Model model, ActionListener menuListener, VFSViewTree.OpHandler treeOpHandler) {
		m_Model = model;
		m_MenuListener = menuListener;
		m_TreeOpHandler = treeOpHandler;
		
		m_LastOpenDirectory = System.getProperty("user.home");

		initComponents();
		
		this.setTitle(String.format("%s %s", Model.getApplicationName(), Model.getVersionString()));
		this.setSize(700, 500);
		
		m_VFSTree.setOperationsHandler(m_TreeOpHandler);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		m_Console = new Console(menuListener);
		m_TabPane.add("Console", m_Console);
		
		this.getRootPane().setDefaultButton(m_Console.getSubmitButton());

		/* This will cause onAdd() to be called for the root */
		m_Model.getVFS().addNotifyHandler(new _NotifyHandler());
	}
	
	public Console getConsole() {
		return m_Console;
	}
	
	private MutableTreeNode _tepkek(Node node) {
		
		DefaultMutableTreeNode tn = new DefaultMutableTreeNode(node);		
		node.setUserObject(tn);

		if(node instanceof DirNode) {
			DirNode dn = (DirNode)node;
			
			for(final Node n: dn)
				tn.add(_tepkek(n));

		} else if(node instanceof FileNode) {
			FileNode fn = (FileNode)node;
		}
		
		return tn;
	}

	public void setPathText(String path) {
		if(path == null)
			path = "";
		
		m_PathField.setText(path);
	}
	
    /**
     * Show the Open File Dialog.
	 * @param folders Select directories only?
     * @return The selected file, or null if the dialog was canceled.
     */
    public File showOpenDialog(boolean folders)
    {
        JFileChooser fc = new JFileChooser(m_LastOpenDirectory);
        fc.setMultiSelectionEnabled(false);
		
		if(!folders) {
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.addChoosableFileFilter(new FileNameExtensionFilter("RAF Index (.raf)", "raf"));
			fc.setAcceptAllFileFilterUsed(false);
		} else {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}

        /* If we've cancelled, do nothing. */
        if(fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
             return null;
        
        File f = fc.getSelectedFile();
        m_LastOpenDirectory = f.getParent();
        
        return f;
    }

	
    /**
     * Show the Save File Dialog.
	 * @param defaultName The default file name.
	 * @param folders Select directories only?
     * @return The selected file, or null if the dialog was canceled.
     */
    public File showSaveDialog(String defaultName, boolean folders)
    {
        JFileChooser fc = new JFileChooser(m_LastOpenDirectory);
		
		if(!folders) {
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setAcceptAllFileFilterUsed(false);
			fc.setSelectedFile(new File(defaultName));
		} else {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}

        /* If we've cancelled, do nothing. */
        if(fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
             return null;
        
        File f = fc.getSelectedFile();
        m_LastOpenDirectory = f.getParent();
        
        return f;
    }

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane mainInfoSplitter = new javax.swing.JSplitPane();
        javax.swing.JSplitPane treePreviewSplitter = new javax.swing.JSplitPane();
        javax.swing.JScrollPane vfsScroll = new javax.swing.JScrollPane();
        m_VFSTree = new net.vs49688.rafview.gui.VFSViewTree();
        m_TabPane = new javax.swing.JTabbedPane();
        m_InfoPanel = new javax.swing.JPanel();
        m_PathField = new javax.swing.JTextField();
        javax.swing.JLabel pathLabel = new javax.swing.JLabel();
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem openArchiveItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem addArchiveItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem openLolDirItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));

        mainInfoSplitter.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        mainInfoSplitter.setResizeWeight(1.0);

        vfsScroll.setMinimumSize(new java.awt.Dimension(128, 23));

        m_VFSTree.setModel(null);
        vfsScroll.setViewportView(m_VFSTree);

        treePreviewSplitter.setLeftComponent(vfsScroll);
        treePreviewSplitter.setRightComponent(m_TabPane);

        mainInfoSplitter.setTopComponent(treePreviewSplitter);

        m_InfoPanel.setMinimumSize(new java.awt.Dimension(0, 64));
        m_InfoPanel.setPreferredSize(new java.awt.Dimension(598, 64));
        m_InfoPanel.setRequestFocusEnabled(false);

        m_PathField.setEditable(false);

        pathLabel.setText("Path:");

        javax.swing.GroupLayout m_InfoPanelLayout = new javax.swing.GroupLayout(m_InfoPanel);
        m_InfoPanel.setLayout(m_InfoPanelLayout);
        m_InfoPanelLayout.setHorizontalGroup(
            m_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, m_InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_PathField, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );
        m_InfoPanelLayout.setVerticalGroup(
            m_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m_InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(m_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathLabel)
                    .addComponent(m_PathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        mainInfoSplitter.setRightComponent(m_InfoPanel);

        fileMenu.setText("File");

        openArchiveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openArchiveItem.setText("Open Archive");
        openArchiveItem.setActionCommand("file->openarchive");
        openArchiveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _forwardMenuCommand(evt);
            }
        });
        fileMenu.add(openArchiveItem);

        addArchiveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        addArchiveItem.setText("Add Archive");
        addArchiveItem.setActionCommand("file->addarchive");
        addArchiveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _forwardMenuCommand(evt);
            }
        });
        fileMenu.add(addArchiveItem);

        openLolDirItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        openLolDirItem.setText("Open LoL Directory");
        openLolDirItem.setActionCommand("file->openlol");
        openLolDirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _forwardMenuCommand(evt);
            }
        });
        fileMenu.add(openLolDirItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Exit");
        exitItem.setActionCommand("file->exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _forwardMenuCommand(evt);
            }
        });
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutBtn.setText("About");
        aboutBtn.setActionCommand("help->about");
        aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _forwardMenuCommand(evt);
            }
        });
        helpMenu.add(aboutBtn);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainInfoSplitter)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainInfoSplitter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _forwardMenuCommand(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__forwardMenuCommand
        m_MenuListener.actionPerformed(evt);
    }//GEN-LAST:event__forwardMenuCommand

	public void invokeLater() {
		SwingUtilities.invokeLater(() -> {
			View.this.setVisible(true);
		});
	}
	
    public void showErrorDialog(String title, String message)
    {
        showErrorDialog(this, title, message);
    }

    public static void showErrorDialog(Component parent, String title, String message)
    {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }
	
	private class _NotifyHandler implements IOperationsNotify {

		@Override
		public void onClear() {

			DefaultMutableTreeNode root = (DefaultMutableTreeNode)m_Model.getVFS().getRoot().getUserObject();
			
			if(root.getChildCount() > 0) {
				DefaultTreeModel model = (DefaultTreeModel)m_VFSTree.getModel();
				for(int i = 0; i < root.getChildCount(); ++i)
					model.removeNodeFromParent((DefaultMutableTreeNode)root.getLastChild());
			}
		}

		@Override
		public void onModify(Node n) {
		}

		@Override
		public void onAdd(Node n) {
			DefaultMutableTreeNode tn = new DefaultMutableTreeNode(n);
			n.setUserObject(tn);
			
			DirNode parent = n.getParent();
			
			if(parent != null) {
				DefaultTreeModel m = (DefaultTreeModel)m_VFSTree.getModel();
				
				DefaultMutableTreeNode tnp = (DefaultMutableTreeNode)parent.getUserObject();
				m.insertNodeInto(tn, tnp, parent.getIndex(n));
			} else {
				m_VFSTree.setModel(new DefaultTreeModel(tn));
			}
		}
	}

	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel m_InfoPanel;
    private javax.swing.JTextField m_PathField;
    private javax.swing.JTabbedPane m_TabPane;
    private net.vs49688.rafview.gui.VFSViewTree m_VFSTree;
    // End of variables declaration//GEN-END:variables
}
