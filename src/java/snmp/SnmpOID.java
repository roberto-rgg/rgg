package snmp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class SnmpOID {

    private List<SnmpObject> snmpObjects;
    private List<SnmpObject> snmpSystem;
    private List<SnmpObject> snmpOperation;
    private List<SnmpObject> snmpStatus;
    private List<SnmpObject> snmpRuntimeData;
    private List<SnmpObject> snmpInputs;
    private List<SnmpObject> snmpSystemInfo;
    private List<SnmpObject> snmpParameters;
    private List<SnmpObject> snmpSystemCommands;
    private List<SnmpObject> snmpLCDCommands;


    /**
     * inicia los oid enlistados, agrupados y con descripciones de variables.
     */
    public void initSnmpObject() {

        snmpObjects = new ArrayList();
        snmpSystem = new ArrayList();
        snmpOperation = new ArrayList();
        snmpStatus = new ArrayList();
        snmpRuntimeData = new ArrayList();
        snmpInputs = new ArrayList();
        snmpSystemInfo = new ArrayList();
        snmpParameters = new ArrayList();
        snmpSystemCommands = new ArrayList();
        snmpLCDCommands = new ArrayList();

        //System (general data)
        snmpSystem.add(new SnmpObject(420, Read.System.SYS_DESCR, "descripcion sistema", null));
        snmpSystem.add(new SnmpObject(421, Read.System.SYS_OBJECT_ID, "sin descripcion", null));
        snmpSystem.add(new SnmpObject(422, Read.System.SYS_UP_TIME, "sin descripcion", null));
        snmpSystem.add(new SnmpObject(423, Read.System.SYS_CONTACT, "sin descripcion", null));
        snmpSystem.add(new SnmpObject(424, Read.System.SYS_NAME, "Nombre Sistema", null));
        snmpSystem.add(new SnmpObject(425, Read.System.SYS_LOCATION, "Localización del sistema", null));
        snmpSystem.add(new SnmpObject(426,Read.System.SYS_SERVICES, "sin descripcion", null));
        
        //operation
        snmpOperation.add(new SnmpObject(0, Read.Operation.SYSTEM_PART_NUMBER, "numero sistema", null));
        snmpOperation.add(new SnmpObject(1, Read.Operation.SYSTEM_SERIAL, "Serie del sistema", null));
        snmpOperation.add(new SnmpObject(2, Read.Operation.SYSTEM_PRODUCT_ID, "id producto", null));
        snmpOperation.add(new SnmpObject(3, Read.Operation.GPS_LATITUDE, "latitud ubicacion", null));
        snmpOperation.add(new SnmpObject(4, Read.Operation.GPS_LONGITUDE, "longitud ubicacion", null));
        //status
        snmpStatus.add(new SnmpObject(5, Read.Status.SYSTEM_STATE_DESC, "descripcion estado del sistema", null));
        snmpStatus.add(new SnmpObject(6, Read.Status.SYSTEM_ONLINE, "sistema en linea", null));
        snmpStatus.add(new SnmpObject(7, Read.Status.SYSTEM_FAULTED, "sistema con falla", null));
        snmpStatus.add(new SnmpObject(8, Read.Status.STACK_FAULTED, "stack del sistema con falla", null));
        snmpStatus.add(new SnmpObject(9, Read.Status.LOW_FUEL, "combustible bajo", null));
        snmpStatus.add(new SnmpObject(10, Read.Status.OUT_OF_FUEL, "sin combustible", null));
        snmpStatus.add(new SnmpObject(11, Read.Status.TOTAL_SYSTEM_CYCLES, "total de ciclos del sistema", null));
        snmpStatus.add(new SnmpObject(12, Read.Status.TOTAL_SYSTEM_RUNTIME, "total system runtime", null));
        snmpStatus.add(new SnmpObject(13, Read.Status.NET_KILOWATT_HOURS, "kilowatt horas", null));
        snmpStatus.add(new SnmpObject(14, Read.Status.OUTPUT_VOLTAGE, "voltage salida", null));
        snmpStatus.add(new SnmpObject(15, Read.Status.OUTPUT_CURRENT, "corriente de salida", null));
        snmpStatus.add(new SnmpObject(16, Read.Status.GROSS_POWER, "sin descripcion", null));
        snmpStatus.add(new SnmpObject(17, Read.Status.SYSTEM_TIME_GMT, "hora GMT del sistema", null));
        snmpStatus.add(new SnmpObject(18, Read.Status.GMT_OFFSET_HOURS, "sin descripción", null));
        snmpStatus.add(new SnmpObject(19, Read.Status.GMT_OFFSET_QUARTER_HOURS, "sin descripción", null));
        snmpStatus.add(new SnmpObject(20, Read.Status.SYSTEM_TIME_LOCAL, "hora local sistema", null));
        //runtimedata
        snmpRuntimeData.add(new SnmpObject(21, Read.RuntimeData.RUNTIME_SYSTEM_STATE, "estado del sistema", null));
        snmpRuntimeData.add(new SnmpObject(22, Read.RuntimeData.RUNTIME_SYSTEM_FAULT, "falla del sistema", null));
        snmpRuntimeData.add(new SnmpObject(23, Read.RuntimeData.RUNTIME_SYSTEM_WARNING, "alertas sistema", null));
        snmpRuntimeData.add(new SnmpObject(24, Read.RuntimeData.RUNTIME_SYSTEM_DOOR_OPEN, "puerta abierta", null));
        snmpRuntimeData.add(new SnmpObject(25, Read.RuntimeData.RUNTIME_SYSTEM_NEEDS_POWER_CYCLE, "ciclos", null));
        snmpRuntimeData.add(new SnmpObject(26, Read.RuntimeData.RUNTIME_MAIN_BOARD_CONNECTED, "tablero principal conectado", null));
        snmpRuntimeData.add(new SnmpObject(27, Read.RuntimeData.RUNTIME_STACK_1_STATE, "estado stack 1", null));
        snmpRuntimeData.add(new SnmpObject(28, Read.RuntimeData.RUNTIME_STACK_2_STATE, "estado stack 2", null));
        snmpRuntimeData.add(new SnmpObject(29, Read.RuntimeData.RUNTIME_STACK_1_FAULT, "falla stack 1", null));
        snmpRuntimeData.add(new SnmpObject(30, Read.RuntimeData.RUNTIME_STACK_2_FAULT ,"falla stack 2", null));
        snmpRuntimeData.add(new SnmpObject(31, Read.RuntimeData.RUNTIME_SYSTEM_PERFORMING_DOSING, "sin descripción", null));

        //inputs
        snmpInputs.add(new SnmpObject(27, Read.Inputs.INPUTS_OUTPUT_VOLTAGE, "voltage de salida", null));
        snmpInputs.add(new SnmpObject(28, Read.Inputs.INPUTS_OUTPUT_CURRENT, "corriente de salida", null));
        snmpInputs.add(new SnmpObject(29, Read.Inputs.INPUTS_TEMP_CABINET, "temperatura gabinete", null));
        snmpInputs.add(new SnmpObject(30, Read.Inputs.INPUTS_FUEL_LEVEL, "nivel de combustible", null));
        snmpInputs.add(new SnmpObject(31, Read.Inputs.INPUTS_REMOTE_START, "partida remota", null));
        
        //systeminfo
        snmpSystemInfo.add(new SnmpObject(40, Read.SystemInfo.SYSTEM_STACK_1_CYCLES, "ciclos stack 1", null));
        snmpSystemInfo.add(new SnmpObject(41, Read.SystemInfo.SYSTEM_STACK_2_CYCLES, "ciclos stack 2", null));
        snmpSystemInfo.add(new SnmpObject(42, Read.SystemInfo.SYSTEM_STACK_1_RUNTIME, "ejecución stack 1", null));
        snmpSystemInfo.add(new SnmpObject(43, Read.SystemInfo.SYSTEM_STACK_2_RUNTIME, "ejecución stack 2", null));
        snmpSystemInfo.add(new SnmpObject(44, Read.SystemInfo.SYSTEM_TOTAL_SYSTEM_CYCLES, "total ciclos sistema", null));
        snmpSystemInfo.add(new SnmpObject(45, Read.SystemInfo.SYSTEM_TOTAL_SYSTEM_RUNTIME, "total sistema en ejecución", null));
        snmpSystemInfo.add(new SnmpObject(46, Read.SystemInfo.SYSTEM_TIME_UNTIL_FILTER_MAINT, "tiempo restante hasta mantención ", null));
        snmpSystemInfo.add(new SnmpObject(47, Read.SystemInfo.SYSTEM_NET_KILOWATT_HOURS, "kilowatts hora", null));
        //parameters
        snmpParameters.add(new SnmpObject(49, Read.Parameters.PARAMS_LIMIT_HEATERS_TO_500W, "sin descripción", null));
        snmpParameters.add(new SnmpObject(50, Read.Parameters.PARAMS_COLD_WEATHER_KIT_PRESENT, "sin descripción", null));
        snmpParameters.add(new SnmpObject(52, Read.Parameters.PARAMS_LOW_FUEL_LEVEL_SETPOINT, "puto de bajo combustible", null));
        snmpParameters.add(new SnmpObject(53, Read.Parameters.PARAMS_START_VOLTAGE_FIRST_STACK, "voltage inicio primer stack", null));
        snmpParameters.add(new SnmpObject(54, Read.Parameters.PARAMS_START_VOLTAGE_SECOND_STACK, "voltage inicio segundo stack", null));
        snmpParameters.add(new SnmpObject(55, Read.Parameters.PARAMS_FLOAT_VOLTAGE, "voltage flotante", null));
        snmpParameters.add(new SnmpObject(56, Read.Parameters.PARAMS_TIME_BETWEEN_FILTER_MAINT, "tiemepo entre mantenciones", null));
        snmpParameters.add(new SnmpObject(57, Read.Parameters.PARAMS_MAX_BATTERY_CURRENT, "corriente maxima de bateria", null));
        snmpParameters.add(new SnmpObject(58, Read.Parameters.PARAMS_MAINTENANCE_HOUR, "horas mantención", null));
        snmpParameters.add(new SnmpObject(59, Read.Parameters.PARAMS_4MA_BATTERY_CURRENT, "sin descripción", null));
        snmpParameters.add(new SnmpObject(60, Read.Parameters.PARAMS_20MA_BATTERY_CURRENT, "sin descripción", null));

        
        snmpObjects.addAll(snmpSystem);
        snmpObjects.addAll(snmpOperation);
        snmpObjects.addAll(snmpInputs);
        //snmpObjects.addAll(snmpLCDCommands);
        snmpObjects.addAll(snmpParameters);
        snmpObjects.addAll(snmpRuntimeData);
        snmpObjects.addAll(snmpStatus);
        //snmpObjects.addAll(snmpSystemCommands);
        snmpObjects.addAll(snmpSystemInfo);

    }

    /**
     * Clase estatica que almacena variables oid de tipo lectura
     */
    public static class Read {

        public static class System {

            public static final String SYS_DESCR = "1.3.6.1.2.1.1.1";
            public static final String SYS_OBJECT_ID = "1.3.36466.1.2.1.1.2";
            public static final String SYS_UP_TIME = "1.3.36466.1.2.1.1.3";
            public static final String SYS_CONTACT = "1.3.6.1.2.1.1.4";
            public static final String SYS_NAME = "1.3.6.1.2.1.1.5";
            public static final String SYS_LOCATION = "1.3.6.1.2.1.1.6";
            public static final String SYS_SERVICES = "1.3.36466.1.2.1.1.7";

        }

        public static class Operation {

            public static final String SYSTEM_PART_NUMBER = "1.3.36466.1.1.1.1.1.1";
            public static final String SYSTEM_SERIAL = "1.3.36466.1.1.1.1.1.2";
            public static final String SYSTEM_PRODUCT_ID = "1.3.36466.1.1.1.1.1.3";
            public static final String GPS_LATITUDE = "1.3.36466.1.1.1.1.1.4";
            public static final String GPS_LONGITUDE = "1.3.36466.1.1.1.1.1.5";

        }

        public static class Status {

            public static final String SYSTEM_STATE_DESC = "1.3.36466.1.1.1.2.1.1";
            public static final String SYSTEM_ONLINE = "1.3.36466.1.1.1.2.1.2";
            public static final String SYSTEM_FAULTED = "1.3.36466.1.1.1.2.1.3";
            public static final String STACK_FAULTED = "1.3.36466.1.1.1.2.1.4";
            public static final String LOW_FUEL = "1.3.36466.1.1.1.2.1.5";
            public static final String OUT_OF_FUEL = "1.3.36466.1.1.1.2.1.6";
            public static final String TOTAL_SYSTEM_CYCLES = "1.3.36466.1.1.1.2.1.7";
            public static final String TOTAL_SYSTEM_RUNTIME = "1.3.36466.1.1.1.2.1.8";
            public static final String NET_KILOWATT_HOURS = "1.3.36466.1.1.1.2.1.9";
            public static final String OUTPUT_VOLTAGE = "1.3.36466.1.1.1.2.1.10";
            public static final String OUTPUT_CURRENT = "1.3.36466.1.1.1.2.1.11";
            public static final String GROSS_POWER = "1.3.36466.1.1.1.2.1.12";
            public static final String SYSTEM_TIME_GMT = "1.3.36466.1.1.1.2.1.13";
            public static final String GMT_OFFSET_HOURS = "1.3.36466.1.1.1.2.1.14";
            public static final String GMT_OFFSET_QUARTER_HOURS = "1.3.36466.1.1.1.2.1.15";
            public static final String SYSTEM_TIME_LOCAL = "1.3.36466.1.1.1.2.1.16";

        }

        public static class RuntimeData {

            public static final String RUNTIME_SYSTEM_STATE = "1.3.36466.1.3.1.1.1.1";
            public static final String RUNTIME_SYSTEM_FAULT = "1.3.36466.1.3.1.1.1.2";
            public static final String RUNTIME_SYSTEM_WARNING = "1.3.36466.1.3.1.1.1.3";
            public static final String RUNTIME_SYSTEM_DOOR_OPEN = "1.3.36466.1.3.1.1.1.4";
            public static final String RUNTIME_SYSTEM_NEEDS_POWER_CYCLE = "1.3.36466.1.3.1.1.1.5";
            public static final String RUNTIME_MAIN_BOARD_CONNECTED = "1.3.36466.1.3.1.1.1.6";
            //TODO: nuevos iod
            public static final String RUNTIME_STACK_1_STATE = "1.3.36466.1.";
            public static final String RUNTIME_STACK_2_STATE = "1.3.36466.1.";
            public static final String RUNTIME_STACK_1_FAULT = "1.3.36466.1.";
            public static final String RUNTIME_STACK_2_FAULT = "1.3.36466.1.";
            public static final String RUNTIME_SYSTEM_PERFORMING_DOSING = "1.3.36466.1.";

        }

        public static class Inputs {

            public static final String INPUTS_OUTPUT_VOLTAGE = "1.3.36466.1.3.1.2.1.1";
            public static final String INPUTS_OUTPUT_CURRENT = "1.3.36466.1.3.1.2.1.2";
            public static final String INPUTS_TEMP_CABINET = "1.3.36466.1.3.1.2.1.3";
            public static final String INPUTS_FUEL_LEVEL = "1.3.36466.1.3.1.2.1.4";
            public static final String INPUTS_REMOTE_START = "1.3.36466.1.3.1.2.1.5";
            //nuevos oid
            public static final String INPUTS_H2_FCM_OVER_PRESSURE = "1.3.36466.1.";
            public static final String INPUTS_BATTERY_CURRENT = "1.3.36466.1.";
            public static final String INPUTS_TEMP_REFORMER_TOP = "1.3.36466.1.";
            public static final String INPUTS_TEMP_REFORMER_BOTTOM = "1.3.36466.1.";
            public static final String INPUTS_TEMP_REFORMATE = "1.3.36466.1.";
            public static final String INPUTS_TEMP_SHOT = "1.3.36466.1.";
            public static final String INPUTS_TEMP_MEMBRANE = "1.3.36466.1.";
            public static final String INPUTS_PFEED = "1.3.36466.1.";
            public static final String INPUTS_PH2_BUFFER = "1.3.36466.1.";
            public static final String INPUTS_CATHODE_EXIT_TEMP_1 = "1.3.36466.1.";
            public static final String INPUTS_CATHODE_EXIT_TEMP_2 = "1.3.36466.1.";
            public static final String INPUTS_STACK_CURRENT_1 = "1.3.36466.1.";
            public static final String INPUTS_STACK_CURRENT_2 = "1.3.36466.1.";
            public static final String INPUTS_STACK_VOLTAGE_1 = "1.3.36466.1.";
            public static final String INPUTS_STACK_VOLTAGE_2 = "1.3.36466.1.";

        }

        public static class SystemInfo {

            public static final String SYSTEM_STACK_1_CYCLES = "1.3.36466.1.3.1.4.1.1";
            public static final String SYSTEM_STACK_2_CYCLES = "1.3.36466.1.3.1.4.1.2";
            public static final String SYSTEM_STACK_1_RUNTIME = "1.3.36466.1.3.1.4.1.3";
            public static final String SYSTEM_STACK_2_RUNTIME = "1.3.36466.1.3.1.4.1.4";
            public static final String SYSTEM_TOTAL_SYSTEM_CYCLES = "1.3.36466.1.3.1.4.1.5";
            public static final String SYSTEM_TOTAL_SYSTEM_RUNTIME = "1.3.36466.1.3.1.4.1.6";
            public static final String SYSTEM_TIME_UNTIL_FILTER_MAINT = "1.3.36466.1.3.1.4.1.7";
            public static final String SYSTEM_NET_KILOWATT_HOURS = "1.3.36466.1.3.1.4.1.8";
            public static final String SYSTEM_NUM_POWER_DEMANDS = "1.3.36466.1.3.1.4.1.9";
            //NUEVAS VARIABLES
            public static final String SYSTEM_NUM_STACK_1_FAULTS = "1.3.36466.1.";
            public static final String SYSTEM_NUM_STACK_2_FAULTS = "1.3.36466.1.";
            public static final String SYSTEM_CURRENT_WARNING = "1.3.36466.1.";
            public static final String SYSTEM_CURRENT_FAULT = "1.3.36466.1.";
            public static final String SYSTEM_NUM_SYSTEM_FAULTS = "1.3.36466.1.";
            public static final String SYSTEM_MAIN_BOARD_SERIAL = "1.3.36466.1.";
            public static final String SYSTEM_LCD_BOARD_SERIAL = "1.3.36466.1.";
            public static final String SYSTEM_STACK_1_SERIAL = "1.3.36466.1.";
            public static final String SYSTEM_STACK_2_SERIAL = "1.3.36466.1.";
            public static final String SYSTEM_MAIN_BOARD_FIRMARE = "1.3.36466.1.";
            public static final String SYSTEM_LCD_BOARD_FIRMWARE = "1.3.36466.1.";
            public static final String SYSTEM_NUM_SUCCESSFUL_RUNS = "1.3.36466.1.";
            public static final String SYSTEM_NUM_FAILED_RUNS = "1.3.36466.1.";
            public static final String SYSTEM_NUM_OTHER_RUNS = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_1_CHANGE_1 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_1_CHANGE_2 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_1_CHANGE_3 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_1_CHANGE_4 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_1_CHANGE_5 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_2_CHANGE_1 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_2_CHANGE_2 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_2_CHANGE_3 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_2_CHANGE_4 = "1.3.36466.1.";
            public static final String SYSTEM_CYCLES_AT_STACK_2_CHANGE_5 = "1.3.36466.1.";

        }

        public static class Parameters {

            public static final String PARAMS_LIMIT_HEATERS_TO_500W = "1.3.36466.1.3.1.5.1.1";
            public static final String PARAMS_COLD_WEATHER_KIT_PRESENT = "1.3.36466.1.3.1.5.1.2";
            public static final String PARAMS_SYSTEM_SOAKED = "1.3.36466.1.3.1.5.1.3";
            public static final String PARAMS_LOW_FUEL_LEVEL_SETPOINT = "1.3.36466.1.3.1.5.1.4";
            public static final String PARAMS_START_VOLTAGE_FIRST_STACK = "1.3.36466.1.3.1.5.1.5";
            public static final String PARAMS_START_VOLTAGE_SECOND_STACK = "1.3.36466.1.3.1.5.1.6";
            public static final String PARAMS_FLOAT_VOLTAGE = "1.3.36466.1.3.1.5.1.7";
            public static final String PARAMS_TIME_BETWEEN_FILTER_MAINT = "1.3.36466.1.3.1.5.1.8";
            public static final String PARAMS_MAX_BATTERY_CURRENT = "1.3.36466.1.3.1.5.1.9";
            public static final String PARAMS_MAINTENANCE_HOUR = "1.3.36466.1.3.1.5.1.10";
            public static final String PARAMS_4MA_BATTERY_CURRENT = "1.3.36466.1.3.1.5.1.11";
            public static final String PARAMS_20MA_BATTERY_CURRENT = "1.3.36466.1.3.1.5.1.12";

            public static final String PARAMS_DAYS_BETWEEN_DIAGS = "1.3.36466.1.";
            public static final String PARAMS_DAYS_SINCE_LAST_SYSTEM_ONLINE = "1.3.36466.1.";
            public static final String PARAMS_DAYS_BETWEEN_DOSING_STARTS = "1.3.36466.1.";
            public static final String PARAMS_FPM_V25 = "1.3.36466.1.";
            public static final String PARAMS_LCD_V25 = "1.3.36466.1.";
            public static final String PARAMS_LOW_PRESSURE_SYSTEM = "1.3.36466.1.";
            public static final String PARAMS_MAINTENANCE_HOUR_2 = "1.3.36466.1.";
            public static final String PARAMS_EXTERNAL_FUEL_SENSOR = "1.3.36466.1.";
            public static final String PARAMS_EXTERNAL_FUEL_SENSOR_EMPTY = "1.3.36466.1.";
            public static final String PARAMS_EXTERNAL_FUEL_SENSOR_FULL = "1.3.36466.1.";

        }

        //TODO:cada variable de FaultHistory tiene 20 REGISTROS diseñar estrategia. 
        public static class FaultHistory {

            public static final String SYSTEM_FAULT_ID = "1.3.36466.1.3.3.1.1.1";
            public static final String SYSTEM_FAULT_TIME = "1.3.36466.1.3.3.1.2";
            public static final String SYSTEM_FAULT_DESCRIPTION = "1.3.36466.1.3.3.1.3";

            public static final String STACK_1_FAULT_ID = "1.3.36466.1.3.3.2.1";
            public static final String STACK_1_FAULT_TIME = "1.3.36466.1.3.3.2.2";
            public static final String STACK_1_FAULT_DESCRIPTION = "1.3.36466.1.3.3.2.3";

            public static final String STACK_2_FAULT_ID = "1.3.36466.1.3.3.3.1";
            public static final String STACK_2_FAULT_TIME = "1.3.36466.1.3.3.3.2";
            public static final String STACK_2_FAULT_DESCRIPTION = "1.3.36466.1.3.3.3.3";

            public static final String SYSTEM_WARNING_ID = "1.3.36466.1.3.3.4.1";
            public static final String SYSTEM_WARNING_TIME = "1.3.36466.1.3.3.4.2";
            public static final String SYSTEM_WARNING_DESCRIPTION = "1.3.36466.1.3.3.4.3";

        }

        public static class LCDDisplay {

            public static final String LCD_DISPLAY_LINE_1 = "1.3.36466.1.";
            public static final String LCD_DISPLAY_LINE_2 = "1.3.36466.1.";
            public static final String LCD_DISPLAY_LINE_3 = "1.3.36466.1.";
            public static final String LCD_DISPLAY_LINE_4 = "1.3.36466.1.";

        }

        public static class SDCard {

            public static final String SD_CARD_PRESENT = "1.3.36466.1.";
        }

    }

    /**
     * Clase estatica que almacena variables oid de tipo Escritura.
     */
    public static class Write {

        public static class System {

            public static final String SYS_NAME = "1.3.6.1.2.1.1.5.0";
            public static final String SYS_LOCATION = "1.3.6.1.2.1.1.6.0";
        }

        public static class Operation {

            public static final String GPS_LATITUDE = "1.3.36466.1.1.1.1.1.4.0";
            public static final String GPS_LONGITUDE = "1.3.36466.1.1.1.1.1.5.0";
        }

        public static class status {

            public static final String SYSTEM_TIME_GMT = "1.3.36466.1.1.1.2.1.13.0";
            public static final String GMT_OFFSET_HOURS = "1.3.36466.1.1.1.2.1.14.0";
            public static final String GMT_OFFSET_QUARTER_HOURS = "1.3.36466.1.1.1.2.1.15.0";
            public static final String SYSTEM_TIME_LOCAL = "1.3.36466.1.1.1.2.1.16.0";
        }

        public static class Parameters {

            public static final String PARAMS_LIMIT_HEATERS_TO_500W = "1.3.36466.1.3.1.5.1.1.0";
            public static final String PARAMS_COLD_WEATHER_KIT_PRESENT = "1.3.36466.1.3.1.5.1.2.0";
            public static final String PARAMS_SYSTEM_SOAKED = "1.3.36466.1.3.1.5.1.3.0";
            public static final String PARAMS_LOW_FUEL_LEVEL_SETPOINT = "1.3.36466.1.3.1.5.1.4.0";
            public static final String PARAMS_START_VOLTAGE_FIRST_STACK = "1.3.36466.1.3.1.5.1.5.0";
            public static final String PARAMS_START_VOLTAGE_SECOND_STACK = "1.3.36466.1.3.1.5.1.6.0";
            public static final String PARAMS_FLOAT_VOLTAGE = "1.3.36466.1.3.1.5.1.7.0";
            public static final String PARAMS_TIME_BETWEEN_FILTER_MAINT = "1.3.36466.1.3.1.5.1.8.0";
            public static final String PARAMS_MAX_BATTERY_CURRENT = "1.3.36466.1.3.1.5.1.9.0";
            public static final String PARAMS_MAINTENANCE_HOUR = "1.3.36466.1.3.1.5.1.10.0";
            public static final String PARAMS_4MA_BATTERY_CURRENT = "1.3.36466.1.3.1.5.1.11.0";
            public static final String PARAMS_20MA_BATTERY_CURRENT = "1.3.36466.1.3.1.5.1.12.0";

        }

        public static class SystemCommands {

            public static final String START = "1.3.36466.1.3.10.1.1.1.0";
            public static final String STOP = "1.3.36466.1.3.10.1.1.2.0";
            public static final String ACK_FAULT = "1.3.36466.1.3.10.1.1.3.0";
            public static final String SELF_DIAGNOSTICS = "1.3.36466.1.3.10.1.1.4.0";
            public static final String RESET_MAINT_TIMER = "1.3.36466.1.3.10.1.1.5.0";

        }

        public static class LCDCommands {

            public static final String LCD_BUTTON_UP = "1.3.36466.1.3.10.2.1.1.0";
            public static final String LCD_BUTTON_DOWN = "1.3.36466.1.3.10.2.1.2.0";
            public static final String LCD_BUTTON_LEFT = "1.3.36466.1.3.10.2.1.3.0";
            public static final String LCD_BUTTON_RIGHT = "1.3.36466.1.3.10.2.1.4.0";
            public static final String LCD_BUTTON_ENTER = "1.3.36466.1.3.10.2.1.5.0";
            public static final String LCD_BUTTON_BACK = "1.3.36466.1.3.10.2.1.6.0";
            public static final String LCD_BUTTON_MENU = "1.3.36466.1.3.10.2.1.7.0";
            public static final String REBOOT_LCD = "1.3.36466.1.3.10.2.1.8.0";
            public static final String LCD_PASSWORD = "1.3.36466.1.3.10.2.1.9.0";

        }
    }

    public List<SnmpObject> getSnmpSystem() {
        return snmpSystem;
    }

    public void setSnmpSystem(List<SnmpObject> snmpSystem) {
        this.snmpSystem = snmpSystem;
    }

    public List<SnmpObject> getSnmpOperation() {
        return snmpOperation;
    }

    public void setSnmpOperation(List<SnmpObject> snmpOperation) {
        this.snmpOperation = snmpOperation;
    }

    public List<SnmpObject> getSnmpStatus() {
        return snmpStatus;
    }

    public void setSnmpStatus(List<SnmpObject> snmpStatus) {
        this.snmpStatus = snmpStatus;
    }

    public List<SnmpObject> getSnmpRuntimeData() {
        return snmpRuntimeData;
    }

    public void setSnmpRuntimeData(List<SnmpObject> snmpRuntimeData) {
        this.snmpRuntimeData = snmpRuntimeData;
    }

    public List<SnmpObject> getSnmpInputs() {
        return snmpInputs;
    }

    public void setSnmpInputs(List<SnmpObject> snmpInputs) {
        this.snmpInputs = snmpInputs;
    }

    public List<SnmpObject> getSnmpSystemInfo() {
        return snmpSystemInfo;
    }

    public void setSnmpSystemInfo(List<SnmpObject> snmpSystemInfo) {
        this.snmpSystemInfo = snmpSystemInfo;
    }

    public List<SnmpObject> getSnmpParameters() {
        return snmpParameters;
    }

    public void setSnmpParameters(List<SnmpObject> snmpParameters) {
        this.snmpParameters = snmpParameters;
    }

    public List<SnmpObject> getSnmpSystemCommands() {
        return snmpSystemCommands;
    }

    public void setSnmpSystemCommands(List<SnmpObject> snmpSystemCommands) {
        this.snmpSystemCommands = snmpSystemCommands;
    }

    public List<SnmpObject> getSnmpLCDCommands() {
        return snmpLCDCommands;
    }

    public void setSnmpLCDCommands(List<SnmpObject> snmpLCDCommands) {
        this.snmpLCDCommands = snmpLCDCommands;
    }

    public List<SnmpObject> getSnmpObjects() {
        return snmpObjects;
    }

    public void setSnmpObjects(List<SnmpObject> snmpObjects) {
        this.snmpObjects = snmpObjects;
    }

    /**
     * //system comands snmpSystemCommands.add(new
     * SnmpObject(Write.SystemCommands.START, "iniciar sistema", null));
     * snmpSystemCommands.add(new SnmpObject(Write.SystemCommands.STOP, "detener
     * sistema", null)); snmpSystemCommands.add(new
     * SnmpObject(Write.SystemCommands.ACK_FAULT, "sin descripción", null));
     * snmpSystemCommands.add(new
     * SnmpObject(Write.SystemCommands.SELF_DIAGNOSTICS, "autodiagnostico",
     * null)); snmpSystemCommands.add(new
     * SnmpObject(Write.SystemCommands.RESET_MAINT_TIMER, "resetear tiempo
     * mantención", null)); //lcd commands snmpLCDCommands.add(new
     * SnmpObject(Write.LCDCommands.LCD_BUTTON_UP, "sin descripción", null));
     * snmpLCDCommands.add(new SnmpObject(Write.LCDCommands.LCD_BUTTON_DOWN,
     * "sin descripción", null)); snmpLCDCommands.add(new
     * SnmpObject(Write.LCDCommands.LCD_BUTTON_LEFT, "sin descripción", null));
     * snmpLCDCommands.add(new SnmpObject(Write.LCDCommands.LCD_BUTTON_RIGHT,
     * "sin descripción", null)); snmpLCDCommands.add(new
     * SnmpObject(Write.LCDCommands.LCD_BUTTON_ENTER, "sin descripción", null));
     * snmpLCDCommands.add(new SnmpObject(Write.LCDCommands.LCD_BUTTON_BACK,
     * "sin descripción", null)); snmpLCDCommands.add(new
     * SnmpObject(Write.LCDCommands.LCD_BUTTON_MENU, "sin descripción", null));
     * snmpLCDCommands.add(new SnmpObject(Write.LCDCommands.REBOOT_LCD, "sin
     * descripción", null)); snmpLCDCommands.add(new
     * SnmpObject(Write.LCDCommands.LCD_PASSWORD, "sin descripción", null));
     *
     */
}
