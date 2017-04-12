
package org.omg.dss;

import javax.xml.ws.WebFault;

import org.omg.dss.exception.UnrecognizedScopedEntityException;


/**
 * This class was generated by Apache CXF 2.2.9
 * Thu Jul 28 08:04:45 MDT 2011
 * Generated source version: 2.2.9
 * 
 */

@WebFault(name = "UnrecognizedScopedEntityException", targetNamespace = "http://www.omg.org/spec/CDSS/201105/dss")
public class UnrecognizedScopedEntityExceptionFault extends Exception {
    public static final long serialVersionUID = 20110728080445L;
    
    private UnrecognizedScopedEntityException unrecognizedScopedEntityException;

    public UnrecognizedScopedEntityExceptionFault() {
        super();
    }
    
    public UnrecognizedScopedEntityExceptionFault(String message) {
        super(message);
    }
    
    public UnrecognizedScopedEntityExceptionFault(String message, Throwable cause) {
        super(message, cause);
    }

    public UnrecognizedScopedEntityExceptionFault(String message, UnrecognizedScopedEntityException unrecognizedScopedEntityException) {
        super(message);
        this.unrecognizedScopedEntityException = unrecognizedScopedEntityException;
    }

    public UnrecognizedScopedEntityExceptionFault(String message, UnrecognizedScopedEntityException unrecognizedScopedEntityException, Throwable cause) {
        super(message, cause);
        this.unrecognizedScopedEntityException = unrecognizedScopedEntityException;
    }

    public UnrecognizedScopedEntityException getFaultInfo() {
        return this.unrecognizedScopedEntityException;
    }
}