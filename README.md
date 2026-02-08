

## Application Flow

```mermaid
flowchart TD
    A[User] --> B[Login Page]
    B --> C{Credentials valid aa?}
    C -- Yes --> D[Dashboard]
    C -- No --> E[Error Message]
