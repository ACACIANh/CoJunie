package kr.universe.cojunie.aws.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.amazon.awssdk.core.exception.SdkException
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest
import software.amazon.awssdk.services.s3.model.GetObjectRequest
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import java.io.InputStream

/**
 * Service for AWS S3 operations
 */
@Service
class S3Service(private val s3Client: S3Client) {
    private val logger = LoggerFactory.getLogger(S3Service::class.java)

    @Value("\${aws.s3.bucket-name}")
    private lateinit var bucketName: String

    @Value("\${aws.s3.region:us-east-1}")
    private lateinit var region: String

    /**
     * Upload a file to S3
     * @param key The object key (file path in S3)
     * @param content The file content as a byte array
     * @param contentType The content type (MIME type)
     * @return The S3 URL of the uploaded file
     */
    fun uploadFile(
        key: String,
        content: ByteArray,
        contentType: String,
    ): String {
        return try {
            val request =
                PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(contentType)
                    .build()

            s3Client.putObject(request, RequestBody.fromBytes(content))
            logger.info("Successfully uploaded file: $key")
            generateS3Url(key)
        } catch (e: SdkException) {
            logger.error("Failed to upload file: $key", e)
            throw RuntimeException("Failed to upload file to S3: ${e.message}", e)
        }
    }

    /**
     * Download a file from S3
     * @param key The object key (file path in S3)
     * @return The file content as an InputStream
     */
    fun downloadFile(key: String): InputStream {
        return try {
            val request =
                GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build()

            logger.info("Successfully downloaded file: $key")
            s3Client.getObject(request)
        } catch (e: SdkException) {
            logger.error("Failed to download file: $key", e)
            throw RuntimeException("Failed to download file from S3: ${e.message}", e)
        }
    }

    /**
     * Delete a file from S3
     * @param key The object key (file path in S3)
     */
    fun deleteFile(key: String) {
        try {
            val request =
                DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build()

            s3Client.deleteObject(request)
            logger.info("Successfully deleted file: $key")
        } catch (e: SdkException) {
            logger.error("Failed to delete file: $key", e)
            throw RuntimeException("Failed to delete file from S3: ${e.message}", e)
        }
    }

    /**
     * Generate S3 URL for the given key
     */
    private fun generateS3Url(key: String): String {
        return "https://$bucketName.s3.$region.amazonaws.com/$key"
    }
}
