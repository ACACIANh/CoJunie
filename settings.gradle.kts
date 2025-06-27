rootProject.name = "CoJunie"

// Application Layer
include("application:core-api")
project(":application:core-api").projectDir = file("application/core-api")

// Domain Layer
include("domain:core-domain")
project(":domain:core-domain").projectDir = file("domain/core-domain")

// Infrastructure Layer
include("infrastructure:db-core")
project(":infrastructure:db-core").projectDir = file("infrastructure/db-core")

include("infrastructure:redis")
project(":infrastructure:redis").projectDir = file("infrastructure/redis")

include("infrastructure:aws")
project(":infrastructure:aws").projectDir = file("infrastructure/aws")

// System Support
include("system:logging")
project(":system:logging").projectDir = file("system/logging")

include("system:monitoring")
project(":system:monitoring").projectDir = file("system/monitoring")

include("system:notification")
project(":system:notification").projectDir = file("system/notification")

// Security
include("security:oauth-client")
project(":security:oauth-client").projectDir = file("security/oauth-client")

// Documentation
include("documentation:swagger")
project(":documentation:swagger").projectDir = file("documentation/swagger")

// Testing
include("testing:test-helper")
project(":testing:test-helper").projectDir = file("testing/test-helper")

include("testing:test-container")
project(":testing:test-container").projectDir = file("testing/test-container")
