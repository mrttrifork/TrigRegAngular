import {Duration} from "luxon";

export default class DurationConverter {
  public static convertToISO8601Duration(humanDuration: string): string | undefined {
    const hours = humanDuration.replace(/,/g, ".");
    const hoursAsNumber = +hours;
    if (isNaN(hoursAsNumber)) {
      return undefined;
    }
    if (hoursAsNumber) {
      const duration = Duration.fromObject({
        minutes: +hoursAsNumber * 60,
      });
      return duration.toISO();
    }
    return undefined;
  }

  public static getMinutes(iso8601Duration: string): number {
    const fromISO = Duration.fromISO(iso8601Duration);
    return fromISO.as("minutes");
  }

  public static toHumanFromMinutes(minutes: number): string {
    const fromMinutes = Duration.fromObject({minutes});
    return DurationConverter.convertToHumanDuration(fromMinutes.toISO());
  }

  public static convertToHumanDuration(iso8601Duration: string): string {
    const fromISO = Duration.fromISO(iso8601Duration);
    return fromISO.as("hours").toLocaleString("da-DK", {
      maximumFractionDigits: 1,
      minimumFractionDigits: 1
    });
  }

  public static isValidHumanDuration(humanDuration: string): boolean {
    const hours = humanDuration.replace(/,/g, ".");
    const hoursAsNumber = +hours;
    if (isNaN(hoursAsNumber)) {
      return false;
    }
    const hoursAsMinutes = +hoursAsNumber * 60;
    if(hoursAsMinutes < 0 || hoursAsMinutes > 1440){
      return false;
    }
    return true;
  }
}
