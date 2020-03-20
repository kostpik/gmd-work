package prop.client.application.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class ContentWidget extends Composite implements HasText {

    private static ContentWidgetUiBinder uiBinder = GWT
            .create(ContentWidgetUiBinder.class);

    interface ContentWidgetUiBinder extends UiBinder<Widget, ContentWidget> {
    }

    public ContentWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

 
    public ContentWidget(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
      
    }


    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub
        
    }

}
