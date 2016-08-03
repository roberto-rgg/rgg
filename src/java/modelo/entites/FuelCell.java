package modelo.entites;

/**
 *
 * @author Roberto
 */
public class FuelCell {

    private int id;
    private Nodo nodo;
    private String systemPartNumber;
    private String systemSerial;
    private String sysDescrib;
    private String sysName;
    private String sysLocation;
    private int gpsLatitude;
    private int gpsLongitud;
    private int stackNumber;
    private Long systemtimeGmt;
    private int gmtOffsethours;
    private int gmtOffsetQuarterHours;
    private Long systemTimelocal;

    //Especificaciones
    private String modelo;
    private String descripcionModelo;
    private double powerRating;
    private double nominalVoltage;
    private double fuelConsumption;
    private double standByPowerConsumAverage;
    private double standByConsumPowerPeek;
    public static final int TAN_SIZE = 225;
    public static final int MAX_AMP = 125;
    public static final int MAX_TEMP_REFORMER = 460;
    public static final int MAX_TEMP_MEMBRANA = 400;

    public static final String TEST_VALUE_STRING = "String de prueba";
    public static final String TEST_VALUE_INT = "17";
    public static final String TEST_VALUE_DOUBLE = "18.7";

    public static final String SYS_DESCR = "1.3.6.1.2.1.1.1";
    public static final String SYS_OBJECT_ID = "1.3.36466.1.2.1.1.2";
    public static final String SYS_UP_TIME = "1.3.36466.1.2.1.1.3";
    public static final String SYS_CONTACT = "1.3.6.1.2.1.1.4";
    public static final String SYS_NAME = "1.3.6.1.2.1.1.5";
    public static final String SYS_LOCATION = "1.3.6.1.2.1.1.6";
    public static final String SYS_SERVICES = "1.3.36466.1.2.1.1.7";
    public static final String SYSTEM_PART_NUMBER = "1.3.36466.1.1.1.1.1.1";
    public static final String SYSTEM_SERIAL = "1.3.36466.1.1.1.1.1.2";
    public static final String SYSTEM_PRODUCT_ID = "1.3.36466.1.1.1.1.1.3";
    public static final String GPS_LATITUDE = "1.3.36466.1.1.1.1.1.4";
    public static final String GPS_LONGITUDE = "1.3.36466.1.1.1.1.1.5";

    public static final String TOTAL_SYSTEM_CYCLES = "1.3.36466.1.1.1.2.1.7";
    public static final String SYSTEM_STATE_DESC = "1.3.36466.1.1.1.2.1.1";
    public static final String SYSTEM_FAULTED = "1.3.36466.1.1.1.2.1.3";
    public static final String OUTPUT_VOLTAGE = "1.3.36466.1.1.1.2.1.10";
    public static final String OUTPUT_CURRENT = "1.3.36466.1.1.1.2.1.11";
    public static final String GROSS_POWER = "1.3.36466.1.1.1.2.1.12";
    public static final String CALCULATED_GROSS_POWER = "1.3.36466.1.3.1.6.2.4";

    public static final String INPUTS_TEMP_REFORMER_BOTTOM = "1.3.36466.1.3.1.2.2.4";
    public static final String INPUTS_TEMP_MEMBRANE = "1.3.36466.1.3.1.2.2.7";
    public static final String SYSTEM_TIME_UNTIL_FILTER_MAINT = "1.3.36466.1.3.1.4.1.7";
    public static final String PARAMS_TIME_BETWEEN_FILTER_MAINT = "1.3.36466.1.3.1.5.1.8";
    public static final String PARAMS_DAYS_SINCE_LAST_SYSTEM_ONLINE = "1.3.36466.1.3.1.5.2.2";
    public static final String INPUTS_FUEL_LEVEL = "1.3.36466.1.3.2.1.4";

    public static final String SYSTEM_ONLINE = "1.3.36466.1.1.1.2.1.2";
    public static final String STACK_FAULTED = "1.3.36466.1.1.1.2.1.4";
    public static final String LOW_FUEL = "1.3.36466.1.1.1.2.1.5";
    public static final String OUT_OF_FUEL = "1.3.36466.1.1.1.2.1.6";
    public static final String TOTAL_SYSTEM_RUNTIME = "1.3.36466.1.1.1.2.1.8";
    public static final String NET_KILOWATT_HOURS = "1.3.36466.1.1.1.2.1.9";

    public static final String SYSTEM_TIME_GMT = "1.3.36466.1.1.1.2.1.13";
    public static final String GMT_OFFSET_HOURS = "1.3.36466.1.1.1.2.1.14";
    public static final String GMT_OFFSET_QUARTER_HOURS = "1.3.36466.1.1.1.2.1.15";
    public static final String SYSTEM_TIME_LOCAL = "1.3.36466.1.1.1.2.1.16";

    public static final String SYSTEM_TOTAL_SYSTEM_RUNTIME = "1.3.36466.1.3.1.4.1.6";
    public static final String SYSTEM_TOTAL_SYSTEM_CYCLES = "1.3.36466.1.3.1.4.1.5";
    public static final String SYSTEM_STACK_1_CYCLES = "1.3.36466.1.3.1.4.1.1";
    public static final String SYSTEM_STACK_2_CYCLES = "1.3.36466.1.3.1.4.1.2";

    public static final String SD_CARD_PRESENT = "1.3.36466.1.3.2.3.2.1";

    public static final String WARNING_DESCRIPTION_VAL_384 = "1.3.36466.1.3.3.4.1.3.1";
    public static final String WARNING_DESCRIPTION_VAL_385 = "1.3.36466.1.3.3.4.1.3.2";
    public static final String WARNING_DESCRIPTION_VAL_386 = "1.3.36466.1.3.3.4.1.3.3";
    public static final String WARNING_DESCRIPTION_VAL_387 = "1.3.36466.1.3.3.4.1.3.4";

    public String snmpOidQuery(String oid) {
        return null;
    }

    public FuelCell() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcionModelo() {
        return descripcionModelo;
    }

    public void setDescripcionModelo(String descripcionModelo) {
        this.descripcionModelo = descripcionModelo;
    }

    public String getSystemPartNumber() {
        return systemPartNumber;
    }

    public void setSystemPartNumber(String systemPartNumber) {
        this.systemPartNumber = systemPartNumber;
    }

    public String getSystemSerial() {
        return systemSerial;
    }

    public void setSystemSerial(String systemSerial) {
        this.systemSerial = systemSerial;
    }

    public String getSysDescrib() {
        return sysDescrib;
    }

    public void setSysDescrib(String sysDescrib) {
        this.sysDescrib = sysDescrib;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysLocation() {
        return sysLocation;
    }

    public void setSysLocation(String sysLocation) {
        this.sysLocation = sysLocation;
    }

    public int getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(int gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public int getGpsLongitud() {
        return gpsLongitud;
    }

    public void setGpsLongitud(int gpsLongitud) {
        this.gpsLongitud = gpsLongitud;
    }

    public double getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(double powerRating) {
        this.powerRating = powerRating;
    }

    public double getNominalVoltage() {
        return nominalVoltage;
    }

    public void setNominalVoltage(double nominalVoltage) {
        this.nominalVoltage = nominalVoltage;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getStandByPowerConsumAverage() {
        return standByPowerConsumAverage;
    }

    public void setStandByPowerConsumAverage(double standByPowerConsumAverage) {
        this.standByPowerConsumAverage = standByPowerConsumAverage;
    }

    public double getStandByConsumPowerPeek() {
        return standByConsumPowerPeek;
    }

    public void setStandByConsumPowerPeek(double standByConsumPowerPeek) {
        this.standByConsumPowerPeek = standByConsumPowerPeek;
    }

    public int getStackNumber() {
        return stackNumber;
    }

    public void setStackNumber(int stackNumber) {
        this.stackNumber = stackNumber;
    }

    public Long getSystemtimeGmt() {
        return systemtimeGmt;
    }

    public void setSystemtimeGmt(Long systemtimeGmt) {
        this.systemtimeGmt = systemtimeGmt;
    }

    public int getGmtOffsethours() {
        return gmtOffsethours;
    }

    public void setGmtOffsethours(int gmtOffsethours) {
        this.gmtOffsethours = gmtOffsethours;
    }

    public int getGmtOffsetQuarterHours() {
        return gmtOffsetQuarterHours;
    }

    public void setGmtOffsetQuarterHours(int gmtOffsetQuarterHours) {
        this.gmtOffsetQuarterHours = gmtOffsetQuarterHours;
    }

    public Long getSystemTimelocal() {
        return systemTimelocal;
    }

    public void setSystemTimelocal(Long systemTimelocal) {
        this.systemTimelocal = systemTimelocal;
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

}
