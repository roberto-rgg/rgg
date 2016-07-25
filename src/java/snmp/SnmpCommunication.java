/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snmp;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 * Clase encargada de comunicarse con el agente SNMP.
 *
 * @author Roberto
 */
public class SnmpCommunication {

    private String communityRead;
    private String communityWrite;
    private int versionSnmp;
    private String ipAddress;
    private String port;

    public SnmpCommunication(String communityRead, String communityWrite, int versionSnmp, String ipAddress, String port) {
        this.communityRead = communityRead;
        this.communityWrite = communityWrite;
        this.versionSnmp = versionSnmp;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public SnmpCustomResponse sendGetString(String oid) throws IOException {

        SnmpCustomResponse respuestaSnmp = new SnmpCustomResponse();
        respuestaSnmp.setNullPDU(false);
        respuestaSnmp.setTimeOut(false);
        respuestaSnmp.setErrorResponse(false);
        TransportMapping transport = new DefaultUdpTransportMapping();
        transport.listen();

        // Create Target Address object
        CommunityTarget comtarget = new CommunityTarget();
        comtarget.setCommunity(new OctetString(communityRead));
        comtarget.setVersion(versionSnmp);
        comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
        comtarget.setRetries(2);
        comtarget.setTimeout(1000);

        // Create the PDU object
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(oid)));
        pdu.setType(PDU.GET);
        pdu.setRequestID(new Integer32(1));

        // Create Snmp object for sending data to Agent
        Snmp snmp = new Snmp(transport);
        ResponseEvent response = snmp.get(pdu, comtarget);

        // Process Agent Response
        if (response != null) {
            PDU responsePDU = response.getResponse();
            if (responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
                int errorIndex = responsePDU.getErrorIndex();
                String errorStatusText = responsePDU.getErrorStatusText();

                respuestaSnmp.setErrorStatus(errorStatus);
                respuestaSnmp.setErrorText(errorStatusText);
                respuestaSnmp.setErrorIndex(errorIndex);
                respuestaSnmp.setErrorResponse(true);

                if (errorStatus == PDU.noError) {
                    respuestaSnmp.setVariable(responsePDU.get(0).getVariable());
                }
            } else {
                respuestaSnmp.setErrorResponse(true);
                respuestaSnmp.setNullPDU(true);
            }
        } else {
            respuestaSnmp.setErrorResponse(true);
            respuestaSnmp.setTimeOut(true);
        }
        snmp.close();
        return respuestaSnmp;
    }

    public SnmpCustomResponse sendGetBashProccess(List<SnmpObject> oidList, String oid) throws IOException {

        SnmpCustomResponse respuestaSnmp = new SnmpCustomResponse();
        TransportMapping transport = new DefaultUdpTransportMapping();
        transport.listen();

        // Create Target Address object
        CommunityTarget comtarget = new CommunityTarget();
        comtarget.setCommunity(new OctetString(communityRead));
        comtarget.setVersion(versionSnmp);
        comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
        comtarget.setRetries(2);
        comtarget.setTimeout(1000);

        // Create the PDU object
        PDU pdu = new PDU();
        for (SnmpObject snmp : oidList) {
            pdu.add(new VariableBinding(new OID(snmp.getOid())));
        }
        pdu.setType(PDU.GET);
        pdu.setRequestID(new Integer32(1));

        // Create Snmp object for sending data to Agent
        Snmp snmp = new Snmp(transport);
        ResponseEvent response = snmp.get(pdu, comtarget);

        // Process Agent Response
        if (response != null) {
            PDU responsePDU = response.getResponse();
            if (responsePDU != null) {

                int errorStatus = responsePDU.getErrorStatus();
                int errorIndex = responsePDU.getErrorIndex();
                String errorStatusText = responsePDU.getErrorStatusText();

                respuestaSnmp.setErrorStatus(errorStatus);
                respuestaSnmp.setErrorText(errorStatusText);
                respuestaSnmp.setErrorIndex(errorIndex);

                if (errorStatus == PDU.noError) {
                    for (int x = 0; x < responsePDU.getVariableBindings().size(); x++) {
                        oidList.get(x).setValor(responsePDU.get(x).toValueString());
                    }
                    respuestaSnmp.setSnmpvariables(oidList);
                }
            } else {
                respuestaSnmp.setNullPDU(true);
            }
        } else {
            respuestaSnmp.setTimeOut(true);
        }
        snmp.close();
        return respuestaSnmp;
    }

    private int sendGetInt(String oid) {
        return -1;
    }

    private double sendGetDouble(String oid) {
        return -1.1;
    }

    private Date sendGetDate(String oid) {
        return null;
    }

    private boolean sendSetSnmp(String value) {
        return false;
    }

    private boolean sendSetSnmp(int value) {
        return false;
    }

    private boolean sendSetSnmp(double value) {
        return false;
    }

    /**
     * Representa una respuesta personalizada de
     */
    public class SnmpCustomResponse {

        private boolean errorResponse;
        private int errorStatus;
        private int errorIndex;
        private String errorText;
        private boolean nullPDU;
        private boolean timeOut;
        private Variable variable;
        private List<SnmpObject> snmpvariables;

        public int getErrorStatus() {
            return errorStatus;
        }

        public void setErrorStatus(int errorStatus) {
            this.errorStatus = errorStatus;
        }

        public String getErrorText() {
            return errorText;
        }

        public void setErrorText(String errorText) {
            this.errorText = errorText;
        }

        public boolean isNullPDU() {
            return nullPDU;
        }

        public void setNullPDU(boolean nullPDU) {
            this.nullPDU = nullPDU;
        }

        public boolean isTimeOut() {
            return timeOut;
        }

        public void setTimeOut(boolean timeOut) {
            this.timeOut = timeOut;
        }

        public Variable getVariable() {
            return variable;
        }

        public void setVariable(Variable variable) {
            this.variable = variable;
        }

        public int getErrorIndex() {
            return errorIndex;
        }

        public void setErrorIndex(int errorIndex) {
            this.errorIndex = errorIndex;
        }

        public List<SnmpObject> getSnmpvariables() {
            return snmpvariables;
        }

        public void setSnmpvariables(List<SnmpObject> snmpvariables) {
            this.snmpvariables = snmpvariables;
        }

        public boolean isErrorResponse() {
            return errorResponse;
        }

        public void setErrorResponse(boolean errorResponse) {
            this.errorResponse = errorResponse;
        }

    }

    public String getCommunityRead() {
        return communityRead;
    }

    public void setCommunityRead(String communityRead) {
        this.communityRead = communityRead;
    }

    public String getCommunityWrite() {
        return communityWrite;
    }

    public void setCommunityWrite(String communityWrite) {
        this.communityWrite = communityWrite;
    }

    public int getVersionSnmp() {
        return versionSnmp;
    }

    public void setVersionSnmp(int versionSnmp) {
        this.versionSnmp = versionSnmp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
