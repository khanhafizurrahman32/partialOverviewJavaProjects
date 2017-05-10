    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public boolean authenticateAmaltheaUser(String username) throws Exception {

        boolean userExistance;

        LOGGER.log(Level.INFO, "authenticateAmaltheaUser entered ");
        LOGGER.log(Level.INFO, "login userName {0}", username);


        try {
            // QUERY_AMALTHEA_AUTHENTICATION is defined as a query String to access Information from Database 
            Query query = entityExternalManager.createNativeQuery(QUERY_AMALTHEA_AUTHENTICATION);
            query.setParameter(1, username);

            String userRole = (String) query.getSingleResult();

            userExistance = true;


        } catch (Exception ex) {
            userExistance = false;
            LOGGER.log(Level.INFO, null, ex);
        }

        return userExistance;
    }