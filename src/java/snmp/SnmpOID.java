/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snmp;

/**
 *
 * @author Roberto
 */
public class SnmpOID {

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
