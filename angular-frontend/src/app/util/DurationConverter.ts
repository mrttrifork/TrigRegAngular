import {Duration} from "luxon";

export default class DurationConverter {
  public static convertToISO8601Duration(humanDuration: string): string | undefined {
    const splitDuration = humanDuration.split(".|,");
    if (splitDuration.length > 1) {
      return undefined;
    }
    const [hour, minute] = splitDuration;
    if (hour) {
      const duration = Duration.fromObject({
        hour: +hour,
        minute: minute ? +minute : 0
      });
      return duration.toISO();
    }
    return undefined;
  }

  public static convertToHumanDuration(iso8601Duration: string): string {
    const fromISO = Duration.fromISO(iso8601Duration);
    const hours = fromISO.hours;
    const minutes = fromISO.minutes;

    const minutesAsHours = minutes ? minutes / 6 : undefined;
    if (hours && minutesAsHours) {
      return `${hours},${minutesAsHours}`
    } else if(hours){
      return `${hours}`;
    } else if(minutesAsHours){
      return `0,${minutesAsHours}`
    }
    return "";
  }
}
