package com.sohlman.liferay.hook.blocking;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BlockingFilter extends BaseFilter {

	@Override
	protected Log getLog() {
		return _log;
	}

	
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {
		if ( _log.isDebugEnabled()) {
			_log.debug("Blocked URL getRequestURI: " + request.getRequestURI() + " QueryString:" + request.getQueryString());
		}
		response.getWriter().write("<html><head><title>Blocked</title></head><body><h1>Blocked</h1></html>");
	}
	
	private Log _log = LogFactoryUtil.getLog(BlockingFilter.class);
}
