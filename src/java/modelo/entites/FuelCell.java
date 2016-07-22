package modelo.entites;

import java.util.List;

/**
 *
 * @author Roberto
 */
public class FuelCell {

    private int id;
    private Nodo nodo;
    private String systemPartNumber;
    private String systemSerial;
    private String gpsLatitude;
    private String gpsLongitud;
    //status
    private String SystemStateDesc;
    private boolean systemOnline;
    private boolean systemFaulted;
    private boolean stackFaulted;
    private boolean lowFuel;
    private boolean outOfFuel;
    private int totalSystemCycles;
    private double totalSystemRuntime;
    private double netKilowattHour;
    private double outputVoltage;
    private double outputCurrrent;
    private double grossPower;
    private int gmtOffsetHours;
    private int gmtOffsetQuarter;
    private int systemTimeLocal;
    //runtimedata
    private int runtimeSystemState;
    private int runtimeSystemFault;
    private int runtimeSystemWarnnig;
    private boolean runtimeSystemDoorOpen;
    private int runtimeSystemNeedsPowerCycle;
    private boolean runtimeMainBoardConnected;
    //inputs
    private double inputsOutputVoltage;
    private double inputsOututsCurrent;
    private double inputsTempCabinet;
    private double inputsFuelLevel;
    private double inputsRemoteStart;
    //system info
    private int systemTotalSystemCycles;
    private double systemTimeUntilFilterMaint;
    private double systemNetKilowattHours;
    private int systemNumPowerDemands;
    //parameters
    private int limitHeaters500w;
    private int coldWeatherkitPresent;
    private double lowFuelLevelSetpoint;
    private double startVoltageFirstStack;
    private double startVoltageSecondStack;
    private double doubleVoltage;
    private double timeBetweenFilterMaint;
    private double maxBatteryCurrent;
    private int maintenceHour;

    private List<StackSystemInfo> stacks;
    private List<SystemFault> systemFault;
    private List<SystemWarning> systemWaring;
    private List<StackFault> stackFault;

    public int getNumberStacks() {
        if (stacks != null) {
            return stacks.size();
        }
        return 0;
    }

    public static class ReadOID {

        public static final String GENERAL_PRODUCT = "1.3.36466.1.1";
        public static final String SYS_DESCR = "1.3.6.1.2.1.1.1";
        public static final String SYS_CONTACT = "1.3.6.1.2.1.1.4";
        public static final String SYS_NAME = "1.3.6.1.2.1.1.5";
        public static final String SYS_LOCATION = "1.3.6.1.2.1.1.6";

        public static class Operation {

            public static final String SYSTEM_PART_NUMBER = "1.3.36466.1.1.1.1.1";
            public static final String SYSTEM_SERIAL = "1.3.36466.1.1.1.1.2";
            public static final String SYSTEM_PRODUCT_ID = "1.3.36466.1.1.1.1.3";
            public static final String GPS_LATITUDE = "1.3.36466.1.1.1.1.4";
            public static final String GPS_LONGITUDE = "1.3.36466.1.1.1.1.5";

        }

        public static class Status {

            public static final String SYSTEM_STATE_DESC = "1.3.36466.1.1.1.2.1";
            public static final String SYSTEM_ONLINE = "1.3.36466.1.1.1.2.2";
            public static final String SYSTEM_FAULTED = "1.3.36466.1.1.1.2.3";
            public static final String STACK_FAULTED = "1.3.36466.1.1.1.2.4";
            public static final String LOW_FUEL = "1.3.36466.1.1.1.2.5";
            public static final String OUT_OF_FUEL = "1.3.36466.1.1.1.2.6";
            public static final String TOTAL_SYSTEM_CYCLES = "1.3.36466.1.1.1.2.7";
            public static final String TOTAL_SYSTEM_RUNTIME = "1.3.36466.1.1.1.2.8";
            public static final String NET_KILOWATT_HOURS = "1.3.36466.1.1.1.2.9";
            public static final String OUTPUT_VOLTAGE = "1.3.36466.1.1.1.2.10";
            public static final String OUTPUT_CURRENT = "1.3.36466.1.1.1.2.11";
            public static final String GROSS_POWER = "1.3.36466.1.1.1.2.12";
            public static final String SYSTEM_TIME_GMT = "1.3.36466.1.1.1.2.13";
            public static final String GMT_OFFSET_HOURS = "1.3.36466.1.1.1.2.14";
            public static final String GMT_OFFSET_QUARTER_HOURS = "1.3.36466.1.1.1.2.15";
            public static final String SYSTEM_TIME_LOCAL = "1.3.36466.1.1.1.2.16";

        }

        public static class RuntimeData {

            public static final String RUNTIME_SYSTEM_STATE = "1.3.36466.1.3.1.1.1";
            public static final String RUNTIME_SYSTEM_FAULT = "1.3.36466.1.3.1.1.2";
            public static final String RUNTIME_SYSTEM_WARNING = "1.3.36466.1.3.1.1.3";
            public static final String RUNTIME_SYSTEM_DOOR_OPEN = "1.3.36466.1.3.1.1.4";
            public static final String RUNTIME_SYSTEM_NEEDS_POWER_CYCLE = "1.3.36466.1.3.1.1.5";
            public static final String RUNTIME_MAIN_BOARD_CONNECTED = "1.3.36466.1.3.1.1.6";

        }

        public static class Inputs {

            public static final String INPUTS_OUTPUT_VOLTAGE = "1.3.36466.1.3.1.2.1";
            public static final String INPUTS_OUTPUT_CURRENT = "1.3.36466.1.3.1.2.2";
            public static final String INPUTS_TEMP_CABINET = "1.3.36466.1.3.1.2.3";
            public static final String INPUTS_FUEL_LEVEL = "1.3.36466.1.3.1.2.4";
            public static final String INPUTS_REMOTE_START = "1.3.36466.1.3.1.2.5";

        }

        public static class SystemInfo {

            public static final String SYSTEM_STACK_1_CYCLES = "1.3.36466.1.3.1.4.1";
            public static final String SYSTEM_STACK_2_CYCLES = "1.3.36466.1.3.1.4.2";
            public static final String SYSTEM_STACK_1_RUNTIME = "1.3.36466.1.3.1.4.3";
            public static final String SYSTEM_STACK_2_RUNTIME = "1.3.36466.1.3.1.4.4";
            public static final String SYSTEM_TOTAL_SYSTEM_CYCLES = "1.3.36466.1.3.1.4.5";
            public static final String SYSTEM_TOTAL_SYSTEM_RUNTIME = "1.3.36466.1.3.1.4.6";
            public static final String SYSTEM_TIME_UNTIL_FILTER_MAINT = "1.3.36466.1.3.1.4.7";
            public static final String SYSTEM_NET_KILOWATT_HOURS = "1.3.36466.1.3.1.4.8";
            public static final String SYSTEM_NUM_POWER_DEMANDS = "1.3.36466.1.3.1.4.9";

        }

        public static class Parameters {

            public static final String PARAMS_LIMIT_HEATERS_TO_500W = "1.3.36466.1.3.1.5.1";
            public static final String PARAMS_COLD_WEATHER_KIT_PRESENT = "1.3.36466.1.3.1.5.2";
            public static final String PARAMS_SYSTEM_SOAKED = "1.3.36466.1.3.1.5.3";
            public static final String PARAMS_LOW_FUEL_LEVEL_SETPOINT = "1.3.36466.1.3.1.5.4";
            public static final String PARAMS_START_VOLTAGE_FIRST_STACK = "1.3.36466.1.3.1.5.5";
            public static final String PARAMS_START_VOLTAGE_SECOND_STACK = "1.3.36466.1.3.1.5.6";
            public static final String PARAMS_FLOAT_VOLTAGE = "1.3.36466.1.3.1.5.7";
            public static final String PARAMS_TIME_BETWEEN_FILTER_MAINT = "1.3.36466.1.3.1.5.8";
            public static final String PARAMS_MAX_BATTERY_CURRENT = "1.3.36466.1.3.1.5.9";
            public static final String PARAMS_MAINTENANCE_HOUR = "1.3.36466.1.3.1.5.10";
            public static final String PARAMS_4MA_BATTERY_CURRENT = "1.3.36466.1.3.1.5.11";
            public static final String PARAMS_20MA_BATTERY_CURRENT = "1.3.36466.1.3.1.5.12";

        }

        public static class FaultHistory {

            public static final String SYSTEM_FAULT_ID = "1.3.36466.1.3.3.1.1";
            public static final String SYSTEM_FAULT_Time = "1.3.36466.1.3.3.1.2";
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

        public static class SystemCommands {

            public static final String START = "1.3.36466.1.3.10.1.1";
            public static final String STOP = "1.3.36466.1.3.10.1.2";
            public static final String ACK_FAULT = "1.3.36466.1.3.10.1.3";
            public static final String SELF_DIAGNOSTICS = "1.3.36466.1.3.10.1.4";
            public static final String RESET_MAINT_TIMER = "1.3.36466.1.3.10.1.5";

        }

        public static class LCDCommands {

            public static final String LCD_BUTTON_UP = "1.3.36466.1.3.10.2.1";
            public static final String LCD_BUTTON_DOWN = "1.3.36466.1.3.10.2.2";
            public static final String LCD_BUTTON_LEFT = "1.3.36466.1.3.10.2.3";
            public static final String LCD_BUTTON_RIGHT = "1.3.36466.1.3.10.2.4";
            public static final String LCD_BUTTON_ENTER = "1.3.36466.1.3.10.2.5";
            public static final String LCD_BUTTON_BACK = "1.3.36466.1.3.10.2.6";
            public static final String LCD_BUTTON_MENU = "1.3.36466.1.3.10.2.7";
            public static final String REBOOT_LCD = "1.3.36466.1.3.10.2.8";
            public static final String LCD_PASSWORD = "1.3.36466.1.3.10.2.9";

        }

    }

    public static class WriteOID {

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

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitud() {
        return gpsLongitud;
    }

    public void setGpsLongitud(String gpsLongitud) {
        this.gpsLongitud = gpsLongitud;
    }

    public double getInputsOutputVoltage() {
        return inputsOutputVoltage;
    }

    public void setInputsOutputVoltage(double inputsOutputVoltage) {
        this.inputsOutputVoltage = inputsOutputVoltage;
    }

    public double getInputsOututsCurrent() {
        return inputsOututsCurrent;
    }

    public void setInputsOututsCurrent(double inputsOututsCurrent) {
        this.inputsOututsCurrent = inputsOututsCurrent;
    }

    public double getInputsTempCabinet() {
        return inputsTempCabinet;
    }

    public void setInputsTempCabinet(double inputsTempCabinet) {
        this.inputsTempCabinet = inputsTempCabinet;
    }

    public double getInputsFuelLevel() {
        return inputsFuelLevel;
    }

    public void setInputsFuelLevel(double inputsFuelLevel) {
        this.inputsFuelLevel = inputsFuelLevel;
    }

    public double getInputsRemoteStart() {
        return inputsRemoteStart;
    }

    public void setInputsRemoteStart(double inputsRemoteStart) {
        this.inputsRemoteStart = inputsRemoteStart;
    }

    public int getLimitHeaters500w() {
        return limitHeaters500w;
    }

    public void setLimitHeaters500w(int limitHeaters500w) {
        this.limitHeaters500w = limitHeaters500w;
    }

    public int getColdWeatherkitPresent() {
        return coldWeatherkitPresent;
    }

    public void setColdWeatherkitPresent(int coldWeatherkitPresent) {
        this.coldWeatherkitPresent = coldWeatherkitPresent;
    }

    public double getLowFuelLevelSetpoint() {
        return lowFuelLevelSetpoint;
    }

    public void setLowFuelLevelSetpoint(double lowFuelLevelSetpoint) {
        this.lowFuelLevelSetpoint = lowFuelLevelSetpoint;
    }

    public double getStartVoltageFirstStack() {
        return startVoltageFirstStack;
    }

    public void setStartVoltageFirstStack(double startVoltageFirstStack) {
        this.startVoltageFirstStack = startVoltageFirstStack;
    }

    public double getStartVoltageSecondStack() {
        return startVoltageSecondStack;
    }

    public void setStartVoltageSecondStack(double startVoltageSecondStack) {
        this.startVoltageSecondStack = startVoltageSecondStack;
    }

    public double getFloatVoltage() {
        return doubleVoltage;
    }

    public void setFloatVoltage(double doubleVoltage) {
        this.doubleVoltage = doubleVoltage;
    }

    public double getTimeBetweenFilterMaint() {
        return timeBetweenFilterMaint;
    }

    public void setTimeBetweenFilterMaint(double timeBetweenFilterMaint) {
        this.timeBetweenFilterMaint = timeBetweenFilterMaint;
    }

    public double getMaxBatteryCurrent() {
        return maxBatteryCurrent;
    }

    public void setMaxBatteryCurrent(double maxBatteryCurrent) {
        this.maxBatteryCurrent = maxBatteryCurrent;
    }

    public int getMaintenceHour() {
        return maintenceHour;
    }

    public void setMaintenceHour(int maintenceHour) {
        this.maintenceHour = maintenceHour;
    }

    public int getRuntimeSystemState() {
        return runtimeSystemState;
    }

    public void setRuntimeSystemState(int runtimeSystemState) {
        this.runtimeSystemState = runtimeSystemState;
    }

    public int getRuntimeSystemFault() {
        return runtimeSystemFault;
    }

    public void setRuntimeSystemFault(int runtimeSystemFault) {
        this.runtimeSystemFault = runtimeSystemFault;
    }

    public int getRuntimeSystemWarnnig() {
        return runtimeSystemWarnnig;
    }

    public void setRuntimeSystemWarnnig(int runtimeSystemWarnnig) {
        this.runtimeSystemWarnnig = runtimeSystemWarnnig;
    }

    public boolean isRuntimeSystemDoorOpen() {
        return runtimeSystemDoorOpen;
    }

    public void setRuntimeSystemDoorOpen(boolean runtimeSystemDoorOpen) {
        this.runtimeSystemDoorOpen = runtimeSystemDoorOpen;
    }

    public int getRuntimeSystemNeedsPowerCycle() {
        return runtimeSystemNeedsPowerCycle;
    }

    public void setRuntimeSystemNeedsPowerCycle(int runtimeSystemNeedsPowerCycle) {
        this.runtimeSystemNeedsPowerCycle = runtimeSystemNeedsPowerCycle;
    }

    public boolean isRuntimeMainBoardConnected() {
        return runtimeMainBoardConnected;
    }

    public void setRuntimeMainBoardConnected(boolean runtimeMainBoardConnected) {
        this.runtimeMainBoardConnected = runtimeMainBoardConnected;
    }

    public String getSystemStateDesc() {
        return SystemStateDesc;
    }

    public void setSystemStateDesc(String SystemStateDesc) {
        this.SystemStateDesc = SystemStateDesc;
    }

    public boolean isSystemOnline() {
        return systemOnline;
    }

    public void setSystemOnline(boolean systemOnline) {
        this.systemOnline = systemOnline;
    }

    public boolean isSystemFaulted() {
        return systemFaulted;
    }

    public void setSystemFaulted(boolean systemFaulted) {
        this.systemFaulted = systemFaulted;
    }

    public boolean isStackFaulted() {
        return stackFaulted;
    }

    public void setStackFaulted(boolean stackFaulted) {
        this.stackFaulted = stackFaulted;
    }

    public boolean isLowFuel() {
        return lowFuel;
    }

    public void setLowFuel(boolean lowFuel) {
        this.lowFuel = lowFuel;
    }

    public boolean isOutOfFuel() {
        return outOfFuel;
    }

    public void setOutOfFuel(boolean outOfFuel) {
        this.outOfFuel = outOfFuel;
    }

    public int getTotalSystemCycles() {
        return totalSystemCycles;
    }

    public void setTotalSystemCycles(int totalSystemCycles) {
        this.totalSystemCycles = totalSystemCycles;
    }

    public double getTotalSystemRuntime() {
        return totalSystemRuntime;
    }

    public void setTotalSystemRuntime(double totalSystemRuntime) {
        this.totalSystemRuntime = totalSystemRuntime;
    }

    public double getNetKilowattHour() {
        return netKilowattHour;
    }

    public void setNetKilowattHour(double netKilowattHour) {
        this.netKilowattHour = netKilowattHour;
    }

    public double getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(double outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public double getOutputCurrrent() {
        return outputCurrrent;
    }

    public void setOutputCurrrent(double outputCurrrent) {
        this.outputCurrrent = outputCurrrent;
    }

    public double getGrossPower() {
        return grossPower;
    }

    public void setGrossPower(double grossPower) {
        this.grossPower = grossPower;
    }

    public int getGmtOffsetHours() {
        return gmtOffsetHours;
    }

    public void setGmtOffsetHours(int gmtOffsetHours) {
        this.gmtOffsetHours = gmtOffsetHours;
    }

    public int getGmtOffsetQuarter() {
        return gmtOffsetQuarter;
    }

    public void setGmtOffsetQuarter(int gmtOffsetQuarter) {
        this.gmtOffsetQuarter = gmtOffsetQuarter;
    }

    public int getSystemTimeLocal() {
        return systemTimeLocal;
    }

    public void setSystemTimeLocal(int systemTimeLocal) {
        this.systemTimeLocal = systemTimeLocal;
    }

    public List<StackSystemInfo> getStacks() {
        return stacks;
    }

    public void setStacks(List<StackSystemInfo> stacks) {
        this.stacks = stacks;
    }

    public List<SystemFault> getSystemFault() {
        return systemFault;
    }

    public void setSystemFault(List<SystemFault> systemFault) {
        this.systemFault = systemFault;
    }

    public List<SystemWarning> getSystemWaring() {
        return systemWaring;
    }

    public void setSystemWaring(List<SystemWarning> systemWaring) {
        this.systemWaring = systemWaring;
    }

    public List<StackFault> getStackFault() {
        return stackFault;
    }

    public void setStackFault(List<StackFault> stackFault) {
        this.stackFault = stackFault;
    }

    public double getDoubleVoltage() {
        return doubleVoltage;
    }

    public void setDoubleVoltage(double doubleVoltage) {
        this.doubleVoltage = doubleVoltage;
    }

    public int getSystemTotalSystemCycles() {
        return systemTotalSystemCycles;
    }

    public void setSystemTotalSystemCycles(int systemTotalSystemCycles) {
        this.systemTotalSystemCycles = systemTotalSystemCycles;
    }

    public double getSystemTimeUntilFilterMaint() {
        return systemTimeUntilFilterMaint;
    }

    public void setSystemTimeUntilFilterMaint(double systemTimeUntilFilterMaint) {
        this.systemTimeUntilFilterMaint = systemTimeUntilFilterMaint;
    }

    public double getSystemNetKilowattHours() {
        return systemNetKilowattHours;
    }

    public void setSystemNetKilowattHours(double systemNetKilowattHours) {
        this.systemNetKilowattHours = systemNetKilowattHours;
    }

    public int getSystemNumPowerDemands() {
        return systemNumPowerDemands;
    }

    public void setSystemNumPowerDemands(int systemNumPowerDemands) {
        this.systemNumPowerDemands = systemNumPowerDemands;
    }

}
