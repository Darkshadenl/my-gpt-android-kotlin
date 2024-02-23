import com.aallam.openai.api.chat.*
import com.aallam.openai.api.core.Role
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.example.my_gpt_impl.BuildConfig
import kotlin.time.Duration.Companion.seconds

class OpenAi {
    private val key = BuildConfig.OPENAI_KEY
    private val openai: OpenAI = OpenAI(
        token = key,
        timeout = Timeout(socket = 60.seconds),
    )

    suspend fun sendMessage(message: String, role: Role, model: ModelId): ChatCompletion {
        val prompt = "Make a joke out of this: '$message'"

        val chatMessage = ChatMessage(
            role = role,
            content = prompt
        )

        val b = ChatCompletionRequestBuilder()
        b.messages = listOf(chatMessage)
        b.model = model
        b.maxTokens = 100
        val chatCompletionRequest: ChatCompletionRequest = b.build()

        return openai.chatCompletion(chatCompletionRequest)
    }

    suspend fun sendMessages(chatMessages: List<ChatMessage>, role: Role, model: ModelId): ChatCompletion {
        val b = ChatCompletionRequestBuilder()
        b.messages = chatMessages
        b.model = model
        b.maxTokens = 100
        val chatCompletionRequest: ChatCompletionRequest = b.build()

        return openai.chatCompletion(chatCompletionRequest)
    }
}
