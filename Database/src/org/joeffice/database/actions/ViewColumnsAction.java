/*
 * Copyright 2013 Japplis.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.joeffice.database.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joeffice.database.JDBCTopComponent;
import org.joeffice.desktop.ui.OfficeTopComponent;
import org.netbeans.swing.etable.ETable;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

/**
 * Action to allow the user to select the column to view.
 *
 * @author Anthony Goubard - Japplis
 */
@ActionID(
        category = "View/Office/Database",
        id = "org.joeffice.database.actions.ViewColumnsAction")
@ActionRegistration(
        iconBase = "org/joeffice/database/actions/tab_delete.png",
        displayName = "#CTL_ViewColumnsAction")
@ActionReferences(value = {
    @ActionReference(path = "Office/Database/Toolbar", position = 1050)})
@Messages({"CTL_ViewColumnsAction=View Columns",
    "MSG_AllColumns=All columns"})
public final class ViewColumnsAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JDBCTopComponent currentTopComponent = OfficeTopComponent.getSelectedComponent(JDBCTopComponent.class);
        if (currentTopComponent != null) {
            ETable table = (ETable) currentTopComponent.getSelectedTableComponent().getDataTable();
            table.showColumnSelectionDialog();
        }
    }
}
