package com.yaroslav.delivery;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CharsetFilter implements Filter {

    private String defaultEncoding = "utf-8";
    private static final String ENCODING = "encoding";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encoding = filterConfig.getInitParameter(ENCODING);
        if(encoding != null){
            defaultEncoding = encoding;

        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(defaultEncoding);
        servletResponse.setCharacterEncoding(defaultEncoding);
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        httpServletRequest.getSession();

        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("locale") == null) {
            session.setAttribute("locale", "ua");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}