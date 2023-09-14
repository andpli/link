import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "linkBean")
public class LinkBean {
    private final LinkStorage ls = new LinkStorage();
    public void resetTable(){
       ls.resetLinks();
    }
    public void getInputLink(){
        FacesContext context = FacesContext.getCurrentInstance();
        String param = context.getExternalContext().getRequestParameterMap().get("form:input_link");
        try {
             ls.addLinks(param);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            showError(e.getMessage());
        }
    }
    public void showError(String error_mess) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", error_mess));
    }
    public List<ParsedLink> getLs() {
        return ls.getLinks();
    }
}