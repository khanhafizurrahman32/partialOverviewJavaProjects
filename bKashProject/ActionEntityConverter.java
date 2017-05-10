public class ActionEntityConverter {

    private static final Logger LOGGER = Logger.getLogger(ActionEntityConverter.class.getName());

    public static ActionBeanRequest getGeneralRequest(ExternalRequest request) {

        ActionBeanRequest beanRequest = new ActionBeanRequest();
        if (request.getUser() != null && !request.getUser().isEmpty()) {
            beanRequest.setUser(request.getUser());
        }
    }
}