rootProject.name = "CoJunie"

// Core modules
include("core-api")
include("core-domain")

// Storage modules
include("db-core")
include("redis")

// Clients modules
include("aws")
include("notification")
include("oauth-client")

// Supports modules
include("logging")
include("monitoring")
include("swagger")

// Tests modules
include("test-helper")
include("test-container")
