package org.capcaval.lafabriquegui.ccdepend;

import org.capcaval.lafabrique.ccdepend.meta.Item;

import javafx.scene.control.ListCell;

public class ListCellImpl extends ListCell<Item> {
    @Override
    public void updateItem(Item item, boolean empty) {
        super.updateItem(item, empty);
 
        if (empty) {
            setText(null);
            setGraphic(null);
        }
        else if(item != null){
        	setText(item.getName());
        	setGraphic(null);
        	//setGraphic(getListView().getGraphic());
        }
    }
}
