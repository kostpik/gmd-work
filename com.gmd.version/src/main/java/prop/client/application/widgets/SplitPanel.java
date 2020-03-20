package prop.client.application.widgets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.jquery.client.api.JQueryElement;

public class SplitPanel extends Composite implements HasText {

    private static SplitPanelUiBinder uiBinder = GWT
            .create(SplitPanelUiBinder.class);

    interface SplitPanelUiBinder extends UiBinder<Widget, SplitPanel> {
    }

    public SplitPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    MaterialButton buttonHideAndShow, experiment, experiment2, hideLeftZone;
    
    @UiField
    MaterialSplitPanel splPanel;
    
    @UiField
    MaterialPanel rigth, left;
    HTMLPanel htmlPanel;

    @UiField
    ContentWidget contentWidget;
    
    HandlerRegistration clickHandler;
    
    public SplitPanel(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
        buttonHideAndShow.setText(firstName);
        splPanel.add(createHTMLPanel());
        splPanel.add(createButton());
        clickBut(null);
        
    }
//    @UiHandler("splPanel")
//    public void clickN(ClickEvent event) {
//        clickBut(null);
//    }
    
    @UiHandler("experiment")
    void onClickL(ClickEvent e) {
        MaterialToast.fireToast("Experiment");
//        splPanel.setBarPosition(200);
        splPanel.unload();
        
    }
    
    public void clickBut(ClickEvent event) {
            MaterialToast.fireToast("clickBut");
            JQueryElement element=splPanel.$this().find("div + div > div").click();
            
            splPanel.setBarPosition(80);
            splPanel.reload();
    }
    
    
    @UiHandler("experiment2")
    void onClick(ClickEvent e) {
        Stream<Element> stream=Arrays.stream(splPanel.$this().get());
      
//       splPanel.$this().click();
       List<NodeList<Node>> list=stream.map(el->el.getChildNodes()).collect(Collectors.toList());
       MaterialToast.fireToast("exp "+splPanel.getBarPosition());
//       Window.alert(list.toString());
       splPanel.reload();
    }

    @UiHandler("hideLeftZone")
    void hideLeftPanel(ClickEvent e) {
        Element element=splPanel.getElement();
        element.getChild(0).appendChild(DOM.createButton());
        GWT.log(""+element.getChild(0).getNodeName());
        GWT.log("kak ec");

// 
//        MaterialToast.fireToast(""+splPanel.getBarPosition()*100);
//        splPanel.setBarPosition(40);
    }

    public void setText(String text) {
        buttonHideAndShow.setText(text);
    }

    public String getText() {
        return buttonHideAndShow.getText();
    }
    
    public HTMLPanel createHTMLPanel() {
        String html="This is a <b>HTMLPanel</b> containing"
                +" html contents. "
                +" <i>By putting some fairly large contents in the middle"
                +" and setting its size explicitly, it becomes a scrollable area"
                +" within the page, but without requiring the use of an IFRAME.</i>"
                +" <u>Here's quite a bit more meaningless text that will serve"
                +" to make this thing scroll off the bottom of its visible area."
                +" Otherwise, you might have to make it really, really"
                +" small in order to see the nifty scroll bars!</u>";
        HTMLPanel panel = new HTMLPanel(html);
        
        return panel;
    }
    
    public MaterialButton createButton(){
        return new MaterialButton("generButton",IconType.ACCESS_ALARM, ButtonType.OUTLINED);
    }

}
