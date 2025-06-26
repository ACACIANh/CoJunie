package kr.universe.cojunie.aws.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
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
    @Value("\${aws.s3.bucket-name}")
    private lateinit var bucketName: String

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
        val request =
            PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(contentType)
                .build()

        s3Client.putObject(request, RequestBody.fromBytes(content))
        return "https://$bucketName.s3.amazonaws.com/$key"
    }

    /**
     * Download a file from S3
     * @param key The object key (file path in S3)
     * @return The file content as an InputStream
     */
    fun downloadFile(key: String): InputStream {
        val request =
            GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build()

        return s3Client.getObject(request)
    }

    /**
     * Delete a file from S3
     * @param key The object key (file path in S3)
     */
    fun deleteFile(key: String) {
        val request =
            DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build()

        s3Client.deleteObject(request)
    }
}
