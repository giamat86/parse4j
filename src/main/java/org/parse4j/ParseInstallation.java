package org.parse4j;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Giamat 1/09/17 
 * The {@code ParseInstallation} is a local (and dummy) representation of installation data that can be saved
 * and retrieved from the Parse cloud.
 */
@ParseClassName("_Installation")
public class ParseInstallation extends ParseObject {
  private static final String TAG = ParseInstallation.class.getSimpleName();

  private static final String KEY_OBJECT_ID = "objectId";
  private static final String KEY_INSTALLATION_ID = "installationId";
  private static final String KEY_DEVICE_TYPE = "deviceType";
  private static final String KEY_APP_NAME = "appName";
  private static final String KEY_APP_IDENTIFIER = "appIdentifier";
  private static final String KEY_PARSE_VERSION = "parseVersion";
  private static final String KEY_DEVICE_TOKEN = "deviceToken";
  private static final String KEY_PUSH_TYPE = "pushType";
  private static final String KEY_TIME_ZONE = "timeZone";
  private static final String KEY_LOCALE = "localeIdentifier";
  private static final String KEY_APP_VERSION = "appVersion";
  /* package */ static final String KEY_CHANNELS = "channels";

  private static final List<String> READ_ONLY_FIELDS = Collections.unmodifiableList(
      Arrays.asList(KEY_DEVICE_TYPE, KEY_INSTALLATION_ID, KEY_DEVICE_TOKEN, KEY_PUSH_TYPE,
          KEY_TIME_ZONE, KEY_LOCALE, KEY_APP_VERSION, KEY_APP_NAME, KEY_PARSE_VERSION,
          KEY_APP_IDENTIFIER, KEY_OBJECT_ID));

  /**
   * Constructs a query for {@code ParseInstallation}.
   * <p/>
   * <strong>Note:</strong> We only allow the following types of queries for installations:
   * <pre>
   * query.get(objectId)
   * query.whereEqualTo("installationId", value)
   * query.whereMatchesKeyInQuery("installationId", keyInQuery, query)
   * </pre>
   * <p/>
   * You can add additional query clauses, but one of the above must appear as a top-level
   * {@code AND} clause in the query.
   *
   * @see com.parse.ParseQuery#getQuery(Class)
   */
  public static ParseQuery<ParseInstallation> getQuery() {
    return ParseQuery.getQuery(ParseInstallation.class);
  }

  public ParseInstallation() {
    // do nothing
  }

  /**
   * Returns the unique ID of this installation.
   *
   * @return A UUID that represents this device.
   */
  public String getInstallationId() {
    return getString(KEY_INSTALLATION_ID);
  }

  @Override
  public void setObjectId(String newObjectId) {
    throw new RuntimeException("Installation's objectId cannot be changed");
  }

  @Override
  /* package */ boolean needsDefaultACL() {
    return false;
  }
}
