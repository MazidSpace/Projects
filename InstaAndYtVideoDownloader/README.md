# Video Downloader API for Instagram & YouTube

A lightweight and high-performance API to download Instagram Stories, Reels, and YouTube videos or audio using simple GET requests.
Completely free to use in your website, apps, or any automation tools.
Currently no usage limits – enjoy! 🎉

## ⚠️ Disclaimer
As you all know I’m a student and this project is for educational purposes only. Please do not use this API for any illegal activity or to violate copyright or platform terms of service.

---

## 🔗 Base URL

```bash
https://mazid-download-api.vercel.app/
```

---

## 🔐 Authentication

The API currently uses a static API key.

- **API Key:** `MazidSpace`  
- Must be passed as a query parameter: `api_key`

---

## 🧩 Common Query Parameters

All endpoints use the following required query parameters:

| Parameter | Type   | Description                          |
|----------|--------|--------------------------------------|
| `url`    | string | The media link you want to download  |
| `api_key`| string | Your API key → `MazidSpace`         |

**Example Query:**

```text
?url={your_media_url}&api_key=MazidSpace
```

---

## 🚀 Endpoints

### 1. Get Instagram Story

Retrieve an Instagram Story video and thumbnail.

**Method:** `GET`  
**Endpoint:** `/GetIgStory`

**Example Request:**

```bash
GET https://mazid-download-api.vercel.app/GetIgStory?url={story_url}&api_key=MazidSpace
```

**Example Response Structure (`200`):**

```json
{
  "download_url": "string (direct video download URL)",
  "image": "string (thumbnail image URL)",
  "type": "string (e.g. "video")",
  "video": "string (video URL)"
}
```

---

### 2. Get Instagram Reel

Retrieve an Instagram Reel video URL.

**Method:** `GET`  
**Endpoint:** `/GetIgReel`

**Example Request:**

```bash
GET https://mazid-download-api.vercel.app/GetIgReel?url={reel_url}&api_key=MazidSpace
```

**Example Response Structure (`200`):**

```json
{
  "success": true,
  "video": "string (reel video URL)"
}
```

---

### 3. Get YouTube Video (MP4 – Full Video)

Fetch both video (multiple qualities) and audio metadata for a YouTube video.

**Method:** `GET`  
**Endpoint:** `/GetYtVideoMp4`

**Example Request:**

```bash
GET https://mazid-download-api.vercel.app/GetYtVideoMp4?url={youtube_url}&api_key=MazidSpace
```

**Example Response Structure (`200`):**

```json
{
  "audio_data": {
    "audio_url": "string (audio stream URL)",
    "success": true
  },
  "video_data": {
    "success": true,
    "thumbnail_url": "string (thumbnail URL)",
    "title": "string (video title)",
    "video_url": [
      {
        "fileSize": "string (size in bytes as string)",
        "hasAudio": false,
        "mimeType": "string (MIME type, e.g. "video/mp4; codecs=..." )",
        "quality": "string (e.g. "144p", "360p", "720p")",
        "url": "string (video stream URL)"
      }
    ]
  }
}
```

---

### 4. Get YouTube Video Only (No Audio)

Fetch video-only streams (no audio) in multiple qualities.

**Method:** `GET`  
**Endpoint:** `/GetYtVideoOnly`

**Example Request:**

```bash
GET https://mazid-download-api.vercel.app/GetYtVideoOnly?url={youtube_url}&api_key=MazidSpace
```

**Example Response Structure (`200`):**

```json
{
  "success": true,
  "video_url": [
    {
      "fileSize": "string (size in bytes as string)",
      "hasAudio": false,
      "mimeType": "string (MIME type, e.g. "video/mp4; codecs=..." )",
      "quality": "string (e.g. "144p", "240p", "360p", "480p", "720p")",
      "url": "string (video-only stream URL)"
    }
  ]
}
```

---

### 5. Get YouTube Audio (MP3 / Audio Stream)

Fetch only the audio stream of a YouTube video.

**Method:** `GET`  
**Endpoint:** `/GetYtVideoMp3`

**Example Request:**

```bash
GET https://mazid-download-api.vercel.app/GetYtVideoMp3?url={youtube_url}&api_key=MazidSpace
```

**Example Response Structure (`200`):**

```json
{
  "audio_url": "string (audio stream URL)",
  "success": true
}
```

---

## ⚠️ HTTP Status Codes

The API uses standard HTTP status codes:

| Status Code | Meaning                                      |
|------------|-----------------------------------------------|
| `200`      | Success – request processed correctly         |
| `400`      | Bad Request – missing or invalid query params |
| `500`      | Internal Server Error – something went wrong  |

---

## 📝 Notes

- All requests **must** use HTTPS.
- Ensure the `url` parameter is **properly URL-encoded**, especially when it contains special characters.
- The `api_key` is currently static: `MazidSpace`.
