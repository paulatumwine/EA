1. implement your own logout
.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")

or

.logout()
            .logoutSuccessHandler(new LogoutSuccessHandler() {

                @Override
                public void onLogoutSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2) throws IOException, ServletException {
                    logger.debug("***onLogoutSuccess***");
                }
            })

2. remember me cookie based
rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400)