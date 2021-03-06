/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Set character encoding filter with the default encoding set 
 *to UTF-8 
 */

package controle;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {
    private String encoding;

    /**
     *
     * @param config 
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
	encoding = config.getInitParameter("requestEncoding");

	if (encoding == null){
	    encoding = "UTF-8";
        }
        else{
            //Nothing to do
        }
    }

    /**
     *
     * @param request
     * @param response
     * @param next
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
			 FilterChain next) throws IOException, ServletException {
	// Respect the client-specified character encoding
	// (see HTTP specification section 3.4.1)
	if (null == request.getCharacterEncoding()){
	    request.setCharacterEncoding(encoding);
        }
        else{
            //Nothing to do
        }

	/**
	 * Set the default response content type and encoding
	 */
	response.setContentType("text/html; charset=UTF-8");
	response.setCharacterEncoding("UTF-8");

	next.doFilter(request, response);
    }

    /**
     *
     */
    @Override
    public void destroy() {
    }
}
