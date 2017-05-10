@Path("/data")
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<String> getExecuteData(ExternalRequest externalRequest) throws Exception {
        LOGGER.log(Level.INFO, "getExecuteData method entered");
       
        List<String> getDataList = new ArrayList<String>();
        Object[] requtestedParams = {externalRequest.getUser(), ...};
        LOGGER.log(Level.INFO, "Tethys getStatementsRequestData Params :: {0} :: {1} :: {2} :: pass = ****** ", requtestedParams);

        try {
            ActionBeanRequest actionBeanRequest = ActionEntityConverter.getGeneralRequest(externalRequest);
            List<String> actionBeanResult = actionRequestRemote.getExecuteLists(actionBeanRequest);

            for (String abr : actionBeanResult) {
                //externalResponse = ActionEntityConverter.getGeneralResult(abr);
                getDataList.add(abr);
            }

        } catch (Exception ex) {
            Logger.getLogger(ExternalInterfaceService.class.getName()).log(Level.SEVERE, null, ex);
        }

        

        return getDataList;
    }