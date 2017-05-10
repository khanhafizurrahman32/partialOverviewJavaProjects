 @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<String> getExecuteLists(ActionBeanRequest request) {

        Object[] requtestedParams = {request.getUser(), ...};

        String reportHeaders = null;

        HashMap<String, String> hashMapped = new HashMap<>(); 

        for (QueryParameterBean qupa : request.getParams()) {
            LOGGER.log(Level.INFO, "hash parameter list now; value is {0}", qupa.getValue());
            hashMapped.put(qupa.getKey(), qupa.getValue());
        }

        ActionBeanResult beanResult = new ActionBeanResult();

        List<String> reportResponseList = new ArrayList<String>();

        LOGGER.log(Level.INFO, "from getExecuteLists Requested Params {0} ", requtestedParams);

        try {
            if (request.getUser().isEmpty() || ...) {
                reportResponseList.add(EMPTY_FIELDS_RESPONSE);
                LOGGER.log(Level.INFO, "from getFieldOptions Requested Params {0} ", EMPTY_FIELDS_RESPONSE);
                return null;
            }

            boolean boolAuthenticAmaltheaUser = this.userManager.authenticateAmaltheaUser(request.getUser());
            LOGGER.log(Level.INFO, "authenticAmaltheaUser result is {0}", boolAuthenticAmaltheaUser);

            String reportId = request.getReportId();

            if (boolAuthenticAmaltheaUser) {
                try {
                    
                    reportResponseList = // call report bean method here

                } catch (Exception ex) {
                    Logger.getLogger(TethysSearchRequestHandlerBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                beanResult.setResponseStatus(ACCESS_DENY_RESPONSE);
            }

        } catch (Exception ex) {
            Logger.getLogger(TethysSearchRequestHandlerBean.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        return reportResponseList;

    }